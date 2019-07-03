/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.service.other.impl;

import com.minivision.reus.common.constants.ReusParams;
import com.minivision.reus.common.dto.entity.ControllerEntity;
import com.minivision.reus.common.dto.entity.DTOEntity;
import com.minivision.reus.common.dto.entity.Entity;
import com.minivision.reus.common.dto.entity.FacadeEntity;
import com.minivision.reus.common.dto.entity.MainServiceEntity;
import com.minivision.reus.common.dto.entity.MapperEntity;
import com.minivision.reus.common.dto.entity.ServiceEntity;
import com.minivision.reus.common.dto.resp.ClassAndPackageResp;
import com.minivision.reus.common.service.other.PackageAndClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <Description>: 获取包名和类名Service实现<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月06日
 */
@Service
@Slf4j
public class PackageAndClassServiceImpl implements PackageAndClassService {

    /**
     * 下划线
     */
    private static final String STRING_SPLIT = "_";

    /**
     * ID
     */
    private static final String ID = "Id";

    /**
     * path
     */
    private static final String PATH = "src/main/java";

    /**
     * Mapper
     */
    private static final String MAPPER = "Mapper";

    @Override
    public ClassAndPackageResp getPackageAndClassByTableName(String tableName) {
        // 将前台传递来的表名进行分割
        List<String> table = new ArrayList<>(Arrays.asList(tableName.split(STRING_SPLIT)));
        // 去掉最前面的前缀
        table.remove(0);
        // 组合成包名
        StringBuffer caseNames = new StringBuffer();
        // 组合成类名
        StringBuffer upperCaseName = new StringBuffer();
        for (String splitName : table) {
            caseNames.append(splitName);
            upperCaseName.append(upperCase(splitName));
        }

        // 全小写
        String caseName = caseNames.toString().toLowerCase();

        // 填充返回对象
        ClassAndPackageResp classAndPackageResp = new ClassAndPackageResp();
        classAndPackageResp.setTableName(tableName);
        classAndPackageResp.setEncoding(null);
        classAndPackageResp.setPaging(true);
        // Entity层信息
        classAndPackageResp.setEntity(new Entity(lowerCase(upperCaseName.toString()) + ID,
                upperCaseName.toString(), ReusParams.PACKAGE_ENTITY_NAME + caseName, PATH, true));
        // DTO层信息
        classAndPackageResp.setDto(new DTOEntity(upperCaseName + "DTO",
                ReusParams.PACKAGE_DTO_NAME + caseName, PATH, true));
        // Mapper层信息
        classAndPackageResp.setMapper(new MapperEntity(upperCaseName + "Mapper",
                ReusParams.PACKAGE_MAPPER_NAME + caseName, PATH, true));
        // Service层信息
        classAndPackageResp.setService(new ServiceEntity(upperCaseName + "Service",
                ReusParams.PACKAGE_SERVICE_NAME + caseName, PATH, true));
        // Controller层信息
        classAndPackageResp.setController(new ControllerEntity(upperCaseName + "Controller",
                ReusParams.PACKAGE_CONTROLLER_NAME + caseName, PATH, true));
        //Facade层信息
        classAndPackageResp.setFacade(new FacadeEntity(upperCaseName + "Facade",
                ReusParams.PACKAGE_FACADE_NAME, PATH, true));
        //MainService层信息
        classAndPackageResp.setMainService(new MainServiceEntity(upperCaseName + "Service",
                ReusParams.PACKAGE_MAIN_SERVICE_NAME, PATH, true));
        return classAndPackageResp;
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

    /**
     * Description: 将字符串首字母小写
     *
     * @param str 表名分割内容
     * @return 首字母大写字符串
     */
    public String lowerCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] = (char) (chars[0] + 32);
        return new String(chars);
    }
}
