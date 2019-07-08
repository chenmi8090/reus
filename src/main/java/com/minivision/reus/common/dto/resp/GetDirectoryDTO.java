/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <Description>: GetDirectoryDTO<br>
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
public class GetDirectoryDTO implements Serializable {

    /**
     * 节点id
     */
    private String id;

    /**
     * 盘符
     */
    private String directory;

}
