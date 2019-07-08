/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.dto.req;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <Description>: GetDirectoryReq<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/07/08
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetDirectoryReq {

    /**
     * 节点id
     */
    @NotEmpty
    private String id;

    /**
     * 盘符
     */
    @NotEmpty
    private String directory;
}
