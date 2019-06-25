/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.dto.req;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <Description>: GetGenerateCodeReq<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月12日
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetGenerateCodeReq {

    @NotEmpty
    private String controllerPackage;

    @NotEmpty
    private String servicePackage;

    @NotEmpty
    private String tableName;

    @NotEmpty
    private String primaryKey;

    @NotEmpty
    private String entityPackage;

    @NotEmpty
    private String mapperPackage;

    @NotEmpty
    private String mapperClassName;

}
