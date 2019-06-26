/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.dto.req;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import com.minivision.reus.common.dto.database.DatabaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * <Description>: CodeReq<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/06/24
 */
@Data
public class CodeReq implements Serializable {

    private DatabaseDTO dataSource;

    @NotEmpty
    private String tableName;

    @NotEmpty
    private String encoding;

    @NotEmpty
    private String controllerPackageName;

    @NotEmpty
    private String servicePackageName;

    private String dtoPackageName;

    @NotEmpty
    private String entityPackageName;

    @NotEmpty
    private String mapperPackageName;

    @NotEmpty
    private String mapperName;

    private String primaryKey = "id";
}
