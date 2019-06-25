package com.minivision.reus.common.service.code.impl;

import com.minivision.common.framework.constant.DigitConst;
import com.minivision.common.framework.facade.exception.BusinessException;
import com.minivision.plus.core.exceptions.MybatisPlusException;
import com.minivision.plus.core.toolkit.StringPool;
import com.minivision.plus.generator.AutoGenerator;
import com.minivision.plus.generator.InjectionConfig;
import com.minivision.plus.generator.config.DataSourceConfig;
import com.minivision.plus.generator.config.FileOutConfig;
import com.minivision.plus.generator.config.GlobalConfig;
import com.minivision.plus.generator.config.PackageConfig;
import com.minivision.plus.generator.config.StrategyConfig;
import com.minivision.plus.generator.config.rules.NamingStrategy;
import com.minivision.plus.generator.engine.FreemarkerTemplateEngine;
import com.minivision.reus.common.dto.code.CodeDTO;
import com.minivision.reus.common.dto.code.DataSourceDto;
import com.minivision.reus.common.service.code.CodeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月30日 <br>
 */
@Service
public class CodeServiceImpl implements CodeService {

    private static final String DOT = ".";

    private static final String URL_SUFFIX = "?useSSL=false&useUnicode=true&characterEncoding=";

    private static final String CONNECTOR = "://";

    private static final String JDBC = "jdbc:";

    private static final String PROJECT_PATH = System.getProperty("java.io.tmpdir");

    private static final String GENERATE_PATH = "/src/main/java";

    @Override
    public String generate(CodeDTO codeDTO) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        setGlobalConfig(mpg);

        // 数据源配置
        setDataSourceConfig(mpg, codeDTO);

        // 包配置
        PackageConfig pc = getPackageConfig(mpg, codeDTO);

        //自定义配置
        setInjectionConfig(mpg, codeDTO, pc);

        // 策略配置
        setStrategyConfig(mpg, codeDTO, pc);

        //启动
        try {
            mpg.execute();
        } catch (MybatisPlusException e) {
            throw new BusinessException("generate error exception {}",e);
        }

        return null;
    }

    private void setStrategyConfig(AutoGenerator mpg, CodeDTO codeDTO, PackageConfig pc) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(codeDTO.getTableName());
        strategy.setSuperEntityColumns(codeDTO.getPrimaryKey());
        strategy.setControllerMappingHyphenStyle(true);
        String tablePrefix = codeDTO.getTableName().split("_")[DigitConst.ZERO]+="_";
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    }

    private void setGlobalConfig(AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + GENERATE_PATH);
        gc.setAuthor("wcx");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
    }

    private String getParentPackageName(CodeDTO codeDTO) {
        String parent = "";

        String[] controller = codeDTO.getControllerPackageName().split(DOT);
        String[] entity = codeDTO.getEntityPackageName().split(DOT);
        String[] mapper = codeDTO.getMapperPackageName().split(DOT);
        String[] service = codeDTO.getServicePackageName().split(DOT);
        if (controller.length == entity.length && entity.length == mapper.length && mapper.length == service.length) {
            for (int i = 0; i < mapper.length; i++) {
                if (controller[i].equals(entity[i]) && entity[i].equals(mapper[i]) && mapper[i].equals(service[i])) {
                    parent = parent + controller[i] + DOT;
                }
            }
        } else {
            //说明每个
            for (int a = 0; a < controller.length; a++) {
                for (int b = 0; b < entity.length; b++) {
                    for (int c = 0; c < mapper.length; c++) {
                        for (int d = 0; d < service.length; d++) {
                            if (controller[a].equals(entity[b]) && entity[b].equals(mapper[c]) && mapper[c].equals(service[d])) {
                                parent = parent + controller[a] + DOT;
                            }
                        }
                    }
                }
            }
        }

        return parent;
    }

    private PackageConfig getPackageConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        PackageConfig pc = new PackageConfig();
        String parent = getParentPackageName(codeDTO);
        pc.setParent(parent);

        codeDTO.getServicePackageName().replaceAll(DOT + pc.getModuleName(), "").replaceAll(parent, "");

        String[] controller = codeDTO.getControllerPackageName().split(DOT);
        String[] entity = codeDTO.getEntityPackageName().split(DOT);
        String[] mapper = codeDTO.getMapperPackageName().split(DOT);
        String[] service = codeDTO.getServicePackageName().split(DOT);
        if (controller[controller.length - 1].equals(entity[entity.length - 1]) &&
                entity[entity.length - 1].equals(mapper[mapper.length - 1]) && mapper[mapper.length - 1].equals(service[service.length - 1])) {
            pc.setModuleName(controller[controller.length - 1]);
        } else {
            String[] split = codeDTO.getTableName().split("_");
            String moduleName = null;
            //过滤表前缀
            for (int i = 1; i < split.length; i++) {
                moduleName += split[i];
            }
            pc.setModuleName(moduleName);
        }
        pc.setService(codeDTO.getServicePackageName().replaceAll(DOT + pc.getModuleName(), "").replaceAll(parent, "")
                .substring(DigitConst.ZERO, codeDTO.getServicePackageName().length()));
        pc.setController(codeDTO.getControllerPackageName().replaceAll(DOT + pc.getModuleName(), "").replaceAll(parent, "")
                .substring(DigitConst.ZERO, codeDTO.getControllerPackageName().length()));
        pc.setMapper(codeDTO.getMapperPackageName().replaceAll(DOT + pc.getModuleName(), "").replaceAll(parent, "")
                .substring(DigitConst.ZERO, codeDTO.getMapperPackageName().length()));
        pc.setEntity(codeDTO.getEntityPackageName().replaceAll(DOT + pc.getModuleName(), "").replaceAll(parent, "")
                .substring(DigitConst.ZERO, codeDTO.getEntityPackageName().length()));
        pc.setServiceImpl(pc.getService() + pc.getModuleName() + pc.getServiceImpl());

        mpg.setPackageInfo(pc);

        return pc;
    }

    private void setDataSourceConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        DataSourceDto dataSource = codeDTO.getDataSource();
        String url = JDBC + dataSource.getDbType() + CONNECTOR + dataSource.getLinkUrl() + ":" + dataSource.getLinkPort()
                + "\\/" + dataSource.getLinkDbName() + URL_SUFFIX + dataSource.getEnCoding();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(dataSource.getLinkUserName());
        dsc.setPassword(dataSource.getLinkPassWord());
        mpg.setDataSource(dsc);
    }

    private void setInjectionConfig(AutoGenerator mpg, CodeDTO codeDTO, PackageConfig pc) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(com.minivision.plus.generator.config.po.TableInfo tableInfo) {
                // 自定义输出文件名
                return PROJECT_PATH + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
    }

}
