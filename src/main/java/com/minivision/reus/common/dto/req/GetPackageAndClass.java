/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <Description>: 获取对应的包名和类名<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月06日
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetPackageAndClass implements Serializable {

    /**
     * Collection包名
     */
    private String collectionPackage;

    /**
     * Service包名
     */
    private String servicePackage;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 主键名称
     */
    private String primaryKey;

    /**
     * Entity类包名
     */
    private String entityClassPackage;

    /**
     * Mapper类包名
     */
    private String mapperClassPackage;

    /**
     * Mapper类名
     */
    private String mapperClassName;

}
