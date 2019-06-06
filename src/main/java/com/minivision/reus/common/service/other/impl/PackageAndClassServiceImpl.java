/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.service.other.impl;

import com.minivision.reus.common.constants.ReusParams;
import com.minivision.reus.common.dto.req.GetPackageAndClass;
import com.minivision.reus.common.service.other.PackageAndClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    private static final String ID = "id";

    /**
     * Mapper
     */
    private static final String MAPPER = "Mapper";

    @Override
    public GetPackageAndClass getPackageAndClassByTableName(String tableName) {
        // 将前台传递来的表名进行分割
        List<String> table = new ArrayList<>(Arrays.asList(tableName.split(STRING_SPLIT)));
        // 去掉最前面的前缀
        table.remove(0);
        // 组合成包名
        StringBuffer caseName = new StringBuffer();
        // 组合成类名
        StringBuffer upperCaseName = new StringBuffer();
        // 组成主键ID
        StringBuffer primaryKeyName = new StringBuffer();
        for (String splitName : table) {
            caseName.append(splitName);
            upperCaseName.append(upperCase(splitName));
            primaryKeyName.append(splitName + STRING_SPLIT);
        }

        // 填充返回对象
        GetPackageAndClass getPackageAndClass = new GetPackageAndClass();
        getPackageAndClass.setMapperClassName(upperCaseName.toString());
        getPackageAndClass.setCollectionPackage(ReusParams.PACKAGE_CONTROLLER_NAME + caseName);
        getPackageAndClass.setServicePackage(ReusParams.PACKAGE_SERVICE_NAME + caseName);
        getPackageAndClass.setMapperClassPackage(ReusParams.PACKAGE_MAPPER_NAME + caseName);
        getPackageAndClass.setEntityClassPackage(ReusParams.PACKAGE_ENTITY_NAME + caseName);
        getPackageAndClass.setPrimaryKey(primaryKeyName.toString() + ID);
        getPackageAndClass.setMapperClassName(upperCaseName.append(MAPPER).toString());
        getPackageAndClass.setTableName(tableName);
        return getPackageAndClass;
    }

    /**
     * Description: 将字符串首字母大写
     *
     * @param str 表名分割内容
     * @return 首字母大写字符串
     */
    public String upperCase(String str) {
        char[] ch = str.toCharArray();
        ch[0] = (char) (ch[0] - 32);
        return new String(ch);
    }
}
