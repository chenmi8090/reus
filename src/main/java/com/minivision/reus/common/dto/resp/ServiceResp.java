/**************************************************************************************** 
           南京小视科技有限公司           
 ****************************************************************************************/
package com.minivision.reus.common.dto.resp;

import com.minivision.reus.common.constants.ReusConstants;
import lombok.*;

import java.io.Serializable;

/**
 * <Description> 返回结果实体<br>
 * 
 * @author houqingqing<br>
 * @version 1.0<br>
 * @param <T> T
 * @taskId <br>
 * @CreateDate 2018年5月16日 <br>
 */

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@ToString
public class ServiceResp<T> implements Serializable {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -2063562870080138843L;

    /**
     * 返回值
     */
    private T data;

    /**
     * 错误code
     */
    @NonNull
    private String code;
    
    /**
     * 消息
     */
    private String msg;

    /**
     * 错误信息
     */
    private Object[] extraMsg;

    /**
     * 无参数构造方法
     */
    public ServiceResp() {
        code = ReusConstants.OPER_SUCC;
    }

}
