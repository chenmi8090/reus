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
import com.minivision.reus.common.dto.database.DatabaseDTO;
import com.minivision.reus.common.dto.database.DbType;
import com.minivision.reus.common.service.code.CodeService;
import com.minivision.reus.common.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private static final String IMPL_KEY = "Impl";

    private static final String URL_SUFFIX = "?useSSL=false&useUnicode=true&characterEncoding=";

    private static final String CONNECTOR = "://";

    private static final String JDBC = "jdbc:";

    private static final String PROJECT_PATH = System.getProperty("user.dir").replaceAll("\\\\", "\\/");

    private static final String GENERATE_PATH = "/generate/zip/src/main/java/";

    @Override
    public String generate(CodeDTO codeDTO) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        setGlobalConfig(mpg, codeDTO);

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
        setStrategyConfig(mpg, codeDTO);

        //启动
        Map<String, String> map = new HashMap<>();
        String execute = null;
        try {
            execute = mpg.execute();
            map.put("path", execute);
        } catch (Exception e) {
            return JsonUtil.getErrorJson(ReusConstants.SYS_ERROR);
        }
        return JsonUtil.getSucc(map, ReusConstants.OPER_SUCC);
    }

    private void setStrategyConfig(AutoGenerator mpg, CodeDTO codeDTO) {
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

    private void setGlobalConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + GENERATE_PATH);
        gc.setOpen(true);
        gc.setAuthor("wcx");
        if (Objects.nonNull(codeDTO.getMapperName())) {
            gc.setMapperName(codeDTO.getMapperName());
        }
        if (Objects.nonNull(codeDTO.getController().getName())) {
            gc.setControllerName(codeDTO.getController().getName());
        }
        if (Objects.nonNull(codeDTO.getService().getName())) {
            gc.setServiceName(codeDTO.getService().getName());
            gc.setServiceImplName(codeDTO.getService().getName() + IMPL_KEY);
        }
        if (Objects.nonNull(codeDTO.getMapper().getName())) {
            gc.setMapperName(codeDTO.getMapper().getName());
        }
        if (Objects.nonNull(codeDTO.getEntity().getName())) {
            gc.setEntityName(codeDTO.getEntity().getName());
        }
        if (Objects.nonNull(codeDTO.getFacade().getName())) {
            gc.setFacadeName(codeDTO.getFacade().getName());
            gc.setFacadeImplName(codeDTO.getFacade().getName() + IMPL_KEY);
        }
        if (Objects.nonNull(codeDTO.getMainService().getName())) {
            gc.setMainServiceName(codeDTO.getMainService().getName());
            gc.setMainServiceImplName(codeDTO.getMainService().getName() + IMPL_KEY);
        }

        mpg.setGlobalConfig(gc);
    }

    private PackageConfig getPackageConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        PackageConfig pc = new PackageConfig();
        pc.setParent("");

        String[] controller = codeDTO.getController().getPackageName().split(DOT);
        String[] entity = codeDTO.getEntity().getPackageName().split(DOT);
        String[] mapper = codeDTO.getMapper().getPackageName().split(DOT);
        String[] service = codeDTO.getService().getPackageName().split(DOT);
        String[] mainService = codeDTO.getMainService().getPackageName().split(DOT);
        String[] facade = codeDTO.getFacade().getPackageName().split(DOT);
        String[] dto = codeDTO.getDto().getPackageName().split(DOT);
        if (controller.length > DigitConst.ZERO && entity.length > DigitConst.ZERO && mapper.length > DigitConst.ZERO
                && service.length > DigitConst.ZERO && mainService.length > DigitConst.ZERO &&
                facade.length > DigitConst.ZERO && dto.length > DigitConst.ZERO) {
            if (controller[controller.length - DigitConst.ONE].equals(entity[entity.length - DigitConst.ONE]) &&
                    entity[entity.length - DigitConst.ONE].equals(mapper[mapper.length - DigitConst.ONE]) &&
                    mapper[mapper.length - DigitConst.ONE].equals(service[service.length - DigitConst.ONE]) &&
                    service[service.length - DigitConst.ONE].equals(mainService[mainService.length - DigitConst.ONE]) &&
                    mainService[mainService.length - DigitConst.ONE].equals(facade[facade.length - DigitConst.ONE]) &&
                    facade[facade.length - DigitConst.ONE].equals(dto[dto.length - DigitConst.ONE])) {
                pc.setModuleName(controller[controller.length - DigitConst.ONE]);
            } else {
                String[] split = codeDTO.getTableName().split("_");
                String moduleName = "";
                Integer count = 0;
                //过滤表前缀
                for (int i = DigitConst.ONE; i < split.length; i++) {
                    if (count != 0) {
                        moduleName += upperCase(split[i]);
                    } else {
                        moduleName += split[i];
                    }
                    count++;
                }
                pc.setModuleName(moduleName);
            }
        }
        pc.setService(codeDTO.getService().getPackageName());
        pc.setServiceImpl(pc.getService() + StringPool.DOT + pc.getServiceImpl());

        pc.setMainService(codeDTO.getMainService().getPackageName());
        pc.setMainServiceImpl(pc.getMainService() + StringPool.DOT + pc.getMainServiceImpl());

        pc.setFacade(codeDTO.getFacade().getPackageName());
        pc.setFacadeImpl(pc.getFacade() + StringPool.DOT + pc.getFacadeImpl());

        pc.setController(codeDTO.getController().getPackageName());

        pc.setMapper(codeDTO.getMapper().getPackageName());

        pc.setEntity(codeDTO.getEntity().getPackageName());

        pc.setReqDto(codeDTO.getDto().getPackageName());

        pc.setRespDto(codeDTO.getDto().getPackageName());

        mpg.setPackageInfo(pc);

        return pc;
    }

    private void setDataSourceConfig(AutoGenerator mpg, CodeDTO codeDTO) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        DatabaseDTO dataSource = codeDTO.getDataSource();
        String url = JDBC + dataSource.getDatabaseType().toLowerCase() + CONNECTOR + dataSource.getHostName() + ":" + dataSource.getPort()
                + "/" + dataSource.getDatabase() + URL_SUFFIX + dataSource.getEncoding();
        dsc.setUrl(url);
        DbType dbType = DbType.valueOf(dataSource.getDatabaseType());
        dsc.setDriverName(dbType.getDriverClass());
        dsc.setUsername(dataSource.getUserName());
        dsc.setPassword(dataSource.getPassword());
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
                return PROJECT_PATH + GENERATE_PATH + "resources/mapper/" + pc.getModuleName() + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

    /**
     * Description: 将字符串首字母大写
     *
     * @param str 表名分割内容
     * @return 首字母大写字符串
     */
    public String upperCase(String str) {
        String lowerCase = str.toLowerCase();
        char[] ch = lowerCase.toCharArray();
        ch[0] = (char) (ch[0] - 32);
        return new String(ch);
    }

}
