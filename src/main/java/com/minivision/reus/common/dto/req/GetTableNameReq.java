/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <Description>: 表名传递参数<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月06日
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetTableNameReq {

    /**
     * 表名
     */
    private String tableName;

}
