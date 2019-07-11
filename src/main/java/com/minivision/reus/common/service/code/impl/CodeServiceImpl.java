package com.minivision.reus.common.service.code.impl;

import com.minivision.common.framework.constant.DigitConst;
import com.minivision.common.framework.facade.exception.BusinessException;
import com.minivision.plus.core.toolkit.StringPool;
import com.minivision.plus.generator.AutoGenerator;
import com.minivision.plus.generator.InjectionConfig;
import com.minivision.plus.generator.config.DataSourceConfig;
import com.minivision.plus.generator.config.FileOutConfig;
import com.minivision.plus.generator.config.GlobalConfig;
import com.minivision.plus.generator.config.PackageConfig;
import com.minivision.plus.generator.config.StrategyConfig;
import com.minivision.plus.generator.config.TemplateConfig;
import com.minivision.plus.generator.config.po.TableInfo;
import com.minivision.plus.generator.config.rules.NamingStrategy;
import com.minivision.plus.generator.engine.FreemarkerTemplateEngine;
import com.minivision.reus.common.constants.ReusConstants;
import com.minivision.reus.common.dto.code.CodeDTO;
import com.minivision.reus.common.dto.database.DatabaseDTO;
import com.minivision.reus.common.dto.database.DbType;
import com.minivision.reus.common.service.code.CodeService;
import com.minivision.reus.common.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
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
        //配置是否生成
        Boolean isGenerateController = codeDTO.getController().getIsGenerate();
        Boolean isGenerateService = codeDTO.getService().getIsGenerate();
        Boolean isGenerateFacade = codeDTO.getFacade().getIsGenerate();
        Boolean isGenerateMainService = codeDTO.getMainService().getIsGenerate();
        Boolean isGenerateDTO = codeDTO.getDto().getIsGenerate();
        Boolean isGenerateEntity = codeDTO.getEntity().getIsGenerate();
        Boolean isGenerateMapper = codeDTO.getMapper().getIsGenerate();
        if (isGenerateController || isGenerateService || isGenerateFacade || isGenerateMainService || isGenerateEntity
                || isGenerateDTO || isGenerateMapper) {
            if (StringUtils.isEmpty(codeDTO.getController().getPath())
                    || StringUtils.isEmpty(codeDTO.getService().getPath())
                    || StringUtils.isEmpty(codeDTO.getFacade().getPath())
                    || StringUtils.isEmpty(codeDTO.getMainService().getPath())
                    || StringUtils.isEmpty(codeDTO.getDto().getPath())
                    || StringUtils.isEmpty(codeDTO.getEntity().getPath())
                    || StringUtils.isEmpty(codeDTO.getMapper().getPath())) {
                return JsonUtil.getErrorJson(ReusConstants.GENERATE_URL_IS_NOT_EMPTY);
            }
        } else if (!isGenerateController && !isGenerateService && !isGenerateFacade && !isGenerateMainService && !isGenerateEntity
                && !isGenerateDTO && !isGenerateMapper) {
            return JsonUtil.getErrorJson(ReusConstants.LESS_GENERATE_CODE);
        }
        templateConfig.setControllerIsGenerator(isGenerateController);
        templateConfig.setServiceIsGenerator(isGenerateService);
        templateConfig.setFacadeIsGenerator(isGenerateFacade);
        templateConfig.setMainServiceIsGenerator(isGenerateMainService);
        templateConfig.setDtoIsGenerator(isGenerateDTO);
        templateConfig.setEntityIsGenerator(isGenerateEntity);
        templateConfig.setMapperIsGenerator(isGenerateMapper);
        mpg.setTemplate(templateConfig);

        //自定义配置
        setInjectionConfig(mpg, codeDTO, pc);

        // 策略配置
        setStrategyConfig(mpg, codeDTO);

        try {
            mpg.execute();
        } catch (Exception e) {
            return JsonUtil.getError(ReusConstants.GENERATE_CODE_ERROR);
        }
        return JsonUtil.getSucc(ReusConstants.OPER_SUCC);
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
        gc.setAuthor(codeDTO.getAuthor());
        Map<String, String> outPutDirs = new HashMap<>();
        if (Objects.nonNull(codeDTO.getMapperName())) {
            // 判断路径是否存在
            if (StringUtils.isNotEmpty(codeDTO.getXmlPath())) {
                // 获取xml文件路径
                outPutDirs.put("xml", codeDTO.getXmlPath());
            }
            gc.setMapperName(codeDTO.getMapperName());
        }
        if (Objects.nonNull(codeDTO.getController().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getController()) && StringUtils.isNotEmpty(codeDTO.getController().getPath())) {
                // 获取controller类路径
                outPutDirs.put("controller", codeDTO.getController().getPath());
            }
            gc.setControllerName(codeDTO.getController().getName());
        }
        if (Objects.nonNull(codeDTO.getService().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getService()) && StringUtils.isNotEmpty(codeDTO.getService().getPath())) {
                // 获取service类路径
                outPutDirs.put("service", codeDTO.getService().getPath());
            }
            gc.setServiceName(codeDTO.getService().getName());
            gc.setServiceImplName(codeDTO.getService().getName() + IMPL_KEY);
        }
        if (Objects.nonNull(codeDTO.getMapper().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getMapper()) && StringUtils.isNotEmpty(codeDTO.getMapper().getPath())) {
                // 获取controller类路径
                outPutDirs.put("mapper", codeDTO.getMapper().getPath());
            }
            gc.setMapperName(codeDTO.getMapper().getName());
        }
        if (Objects.nonNull(codeDTO.getEntity().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getEntity()) && StringUtils.isNotEmpty(codeDTO.getEntity().getPath())) {
                // 获取entity类路径
                outPutDirs.put("entity", codeDTO.getEntity().getPath());
            }
            gc.setEntityName(codeDTO.getEntity().getName());
        }
        if (Objects.nonNull(codeDTO.getFacade().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getFacade()) && StringUtils.isNotEmpty(codeDTO.getFacade().getPath())) {
                // 获取facade类路径
                outPutDirs.put("facade", codeDTO.getFacade().getPath());
            }
            gc.setFacadeName(codeDTO.getFacade().getName());
        }
        if (Objects.nonNull(codeDTO.getFacadeImplPath())) {
            // 判断路径是否存在
            if (StringUtils.isNotEmpty(codeDTO.getFacadeImplPath())) {
                // 获取facade类路径
                outPutDirs.put("facadeImpl", codeDTO.getFacadeImplPath());
            }
            gc.setFacadeImplName(codeDTO.getFacade().getName() + IMPL_KEY);
        }
        if (Objects.nonNull(codeDTO.getMainService().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getMainService()) && StringUtils.isNotEmpty(codeDTO.getMainService().getPath())) {
                // 获取facade类路径
                outPutDirs.put("mainService", codeDTO.getMainService().getPath());
            }
            gc.setMainServiceName(codeDTO.getMainService().getName());
            gc.setMainServiceImplName(codeDTO.getMainService().getName() + IMPL_KEY);
        }
        if (Objects.nonNull(codeDTO.getDto().getName())) {
            // 判断路径是否存在
            if (Objects.nonNull(codeDTO.getDto()) && StringUtils.isNotEmpty(codeDTO.getDto().getPath())) {
                // 获取facade类路径
                outPutDirs.put("dto", codeDTO.getDto().getPath());
            }
            gc.setReqDtoName(codeDTO.getDto().getName().replaceAll("DTO", "ReqDTO"));
            gc.setRespDtoName(codeDTO.getDto().getName().replaceAll("DTO", "RespDTO"));
        }
        // 为当前参数赋值
        gc.setOutPutDirs(outPutDirs);
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

        pc.setFacadeImpl(codeDTO.getFacade().getPackageName() + StringPool.DOT + pc.getFacadeImpl());

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
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return codeDTO.getXmlPath() + "/mapper/" + pc.getModuleName() + "/"
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
