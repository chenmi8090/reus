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
import java.util.List;

/**
 * <Description>: NodeTreeRespDTO<br>
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
public class NodeTreeRespDTO implements Serializable {

    /**
     * 节点ID
     */
    private String Id;

    /**
     * 节点名称
     */
    private String label;

    /**
     * 盘符路径
     */
    private String value;
}
