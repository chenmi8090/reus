/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.service.other;

import com.minivision.reus.common.dto.resp.ClassAndPackageResp;

/**
 * <Description>: 获取包名和类名Service<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月06日
 */
public interface PackageAndClassService {

    /**
     * Description: 根据表名获取包名和类名 <br>
     *
     * @param tableName 表名 <br>
     * @return 类名表名结合实体 <br>
     */
    ClassAndPackageResp getPackageAndClassByTableName(String tableName);

}
