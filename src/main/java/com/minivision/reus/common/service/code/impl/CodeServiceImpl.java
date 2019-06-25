package com.minivision.reus.common.service.code.impl;

import com.minivision.common.framework.constant.DigitConst;
import com.minivision.plus.core.exceptions.MybatisPlusException;
import com.minivision.plus.core.toolkit.StringPool;
import com.minivision.plus.generator.AutoGenerator;
import com.minivision.plus.generator.InjectionConfig;
import com.minivision.plus.generator.config.DataSourceConfig;
import com.minivision.plus.generator.config.FileOutConfig;
import com.minivision.plus.generator.config.GlobalConfig;
import com.minivision.plus.generator.config.PackageConfig;
import com.minivision.plus.generator.config.StrategyConfig;
import com.minivision.plus.generator.config.TemplateConfig;
import com.minivision.plus.generator.config.rules.NamingStrategy;
import com.minivision.plus.generator.engine.FreemarkerTemplateEngine;
import com.minivision.reus.common.constants.ReusConstants;
import com.minivision.reus.common.dto.code.CodeDTO;
import com.minivision.reus.common.dto.code.DataSourceDto;
import com.minivision.reus.common.exception.ReusException;
import com.minivision.reus.common.service.code.CodeService;
import com.minivision.reus.common.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version DigitConst.ONE.DigitConst.ZERO<br>
 * @taskId <br>
 * @CreateDate 2DigitConst.ZERODigitConst.ONE8年DigitConst.ONEDigitConst.ONE月3DigitConst.ZERO日 <br>
 */
@Service
public class CodeServiceImpl implements CodeService {

    private static final String DOT = "\\.";

    private static final String ID_KEY = "id";

    private static final String URL_SUFFIX = "?useSSL=false&useUnicode=true&characterEncoding=";

    private static final String CONNECTOR = "://";

    private static final String JDBC = "jdbc:";

    private static final String PROJECT_PATH = System.getProperty("java.io.tmpdir");

    private static final String GENERATE_PATH = "/src/main/resources";

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

        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //自定义配置
        setInjectionConfig(mpg, codeDTO, pc);

        // 策略配置
        setStrategyConfig(mpg, codeDTO, pc);

        //启动
        try {
            mpg.execute();
        } catch (MybatisPlusException e) {
            throw new ReusException("generate error exception {}", e);
        }
        return JsonUtil.getSucc(ReusConstants.OPER_SUCC);
    }

    private void setStrategyConfig(AutoGenerator mpg, CodeDTO codeDTO, PackageConfig pc) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(codeDTO.getTableName());
        if (Objects.nonNull(codeDTO.getPrimaryKey())) {
            strategy.setSuperEntityColumns(codeDTO.getPrimaryKey());
        } else {
            strategy.setSuperEntityColumns(ID_KEY);
        }
        strategy.setControllerMappingHyphenStyle(true);
        String tablePrefix = codeDTO.getTableName().split("_")[DigitConst.ZERO] += "_";
        strategy.setTablePrefix(new String[] { tablePrefix });
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    }

    private void setGlobalConfig(AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + GENERATE_PATH);
        gc.setOpen(true);
        gc.setAuthor("wcx");
        mpg.setGlobalConfig(gc);
    }

    private String getParentPackageName(CodeDTO codeDTO) {
        String parent = "";
        String[] controller = codeDTO.getControllerPackageName().split(DOT);
        String[] entity = codeDTO.getEntityPackageName().split(DOT);
        String[] mapper = codeDTO.getMapperPackageName().split(DOT);
        String[] service = codeDTO.getServicePackageName().split(DOT);
        if (controller.length == entity.length && entity.length == mapper.length && mapper.length == service.length) {
            for (int i = DigitConst.ZERO; i < mapper.length - DigitConst.ONE; i++) {
                if (controller[i].equals(entity[i]) && entity[i].equals(mapper[i]) && mapper[i].equals(service[i])) {
                    parent = parent + controller[i] + StringPool.DOT;
                }
            }
        } else {
            //说明每个
            for (int a = DigitConst.ZERO; a < controller.length - DigitConst.ONE; a++) {
                for (int b = DigitConst.ZERO; b < entity.length - DigitConst.ONE; b++) {
                    for (int c = DigitConst.ZERO; c < mapper.length - DigitConst.ONE; c++) {
                        for (int d = DigitConst.ZERO; d < service.length - DigitConst.ONE; d++) {
                            if (controller[a].equals(entity[b]) && entity[b].equals(mapper[c]) && mapper[c].equals(service[d])) {
                                parent = parent + controller[a] + StringPool.DOT;
                            }
                        }
                    }
                }
            }
        }

        return parent.substring(DigitConst.ZERO, parent.length() - DigitConst.ONE);
    }

    private PackageConfig getPackageConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        PackageConfig pc = new PackageConfig();
        String parent = getParentPackageName(codeDTO);
        pc.setParent(parent);

        String[] controller = codeDTO.getControllerPackageName().split(DOT);
        String[] entity = codeDTO.getEntityPackageName().split(DOT);
        String[] mapper = codeDTO.getMapperPackageName().split(DOT);
        String[] service = codeDTO.getServicePackageName().split(DOT);
        if (controller.length > DigitConst.ZERO && entity.length > DigitConst.ZERO && mapper.length > DigitConst.ZERO
                && service.length > DigitConst.ZERO) {
            if (controller[controller.length - DigitConst.ONE].equals(entity[entity.length - DigitConst.ONE]) &&
                    entity[entity.length - DigitConst.ONE].equals(mapper[mapper.length - DigitConst.ONE]) && mapper[mapper.length - DigitConst.ONE]
                    .equals(service[service.length - DigitConst.ONE])) {
                pc.setModuleName(controller[controller.length - DigitConst.ONE]);
            } else {
                String[] split = codeDTO.getTableName().split("_");
                String moduleName = "";
                //过滤表前缀
                for (int i = DigitConst.ONE; i < split.length; i++) {
                    moduleName += split[i];
                }
                pc.setModuleName(moduleName);
            }
        }
        pc.setService(codeDTO.getServicePackageName().replaceAll(StringPool.DOT + pc.getModuleName(), "").replaceAll(parent + StringPool.DOT, ""));
        pc.setController(
                codeDTO.getControllerPackageName().replaceAll(StringPool.DOT + pc.getModuleName(), "").replaceAll(parent + StringPool.DOT, ""));
        pc.setMapper(codeDTO.getMapperPackageName().replaceAll(StringPool.DOT + pc.getModuleName(), "").replaceAll(parent + StringPool.DOT, ""));
        pc.setEntity(codeDTO.getEntityPackageName().replaceAll(StringPool.DOT + pc.getModuleName(), "").replaceAll(parent + StringPool.DOT, ""));
        pc.setServiceImpl(pc.getService() + StringPool.DOT + pc.getModuleName() + StringPool.DOT + pc.getServiceImpl());

        mpg.setPackageInfo(pc);

        return pc;
    }

    private void setDataSourceConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        DataSourceDto dataSource = codeDTO.getDataSource();
        String url = JDBC + dataSource.getDbType() + CONNECTOR + dataSource.getLinkUrl() + ":" + dataSource.getLinkPort()
                + "/" + dataSource.getLinkDbName() + URL_SUFFIX + dataSource.getEnCoding();
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

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

}
