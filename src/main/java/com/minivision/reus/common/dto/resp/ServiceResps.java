/**************************************************************************************** 
           南京小视科技有限公司           
 ****************************************************************************************/
package com.minivision.reus.common.dto.resp;

import com.minivision.reus.common.constants.ReusConstants;

import java.util.Optional;

/**
 * <Description> 结果集构造工具类<br>
 * 
 * @author houqingqing<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年5月16日 <br>
 */
public class ServiceResps {

    /**
     * 私有构造方法
     */
    private ServiceResps() {
    }

    /**
     * Description: 获取错误结果<br>
     * 
     * @author houqingqing<br>
     * @param <T> T
     * @taskId <br>
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp}<br>
     */
    public static <T> ServiceResp<T> newErrorResp() {
        return new ServiceResp<>(null, ReusConstants.SYS_ERROR, null, null);
    }

    /**
     * Description: 获取错误结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param t 结果集
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newErrorResp(T t) {
        return new ServiceResp<>(t, ReusConstants.SYS_ERROR, null, null); // 默认错误code
    }

    /**
     * Description: 获取成功结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param t 结果集
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newSuccessResp(T t) {
        return new ServiceResp<>(t, ReusConstants.OPER_SUCC, null, null); // 默认成功code
    }

    /**
     * Description: 获取成功结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newSuccessResp() {
        return new ServiceResp<>(null, ReusConstants.OPER_SUCC, null, null); // 默认成功code
    }

    /**
     * Description: 构造facade返回结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param data 返回数据
     * @param code 返回code
     * @param extraMsg 附加消息
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newResp(T data, String code, Object[] extraMsg) {
        return new ServiceResp<>(data, code, null, extraMsg);
    }
    
    /**
     * Description: 构造facade返回结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param data 返回数据
     * @param code 返回code
     * @param msg 返回消息
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newResp(T data, String code, String msg) {
        return new ServiceResp<>(data, code, msg, null);
    }

    /**
     * Description: 构造facade返回结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param data 返回数据
     * @param code 返回code
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newResp(T data, String code) {
        return new ServiceResp<>(data, code, null, null);
    }

    /**
     * Description: 构造facade返回结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param code 返回code
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newResp(String code) {
        return ServiceResp.of(code);
    }

    /**
     * Description: 构造facade返回结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param code 返回code
     * @param extraMsg 返回msg
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newResp(String code, Object[] extraMsg) {
        return new ServiceResp<>(null, code, null, extraMsg);
    }
    
    /**
     * Description: 构造facade返回结果<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param <T> T
     * @param code 返回code
     * @param msg 返回msg
     * @return {@link com.minivision.reus.common.dto.resp.ServiceResp} <br>
     */
    public static <T> ServiceResp<T> newResp(String code, String msg) {
        return new ServiceResp<>(null, code, msg, null);
    }

    /**
     * Description: 从facade得到实体数据<br>
     * 
     * @author houqingqing<br>
     * @taskId <br>
     * @param resp {@link com.minivision.reus.common.dto.resp.ServiceResp}
     * @return 实体数据<br>
     */
    public static <T> Optional<T> getData(ServiceResp<T> resp) {
        return Optional.ofNullable(Optional.ofNullable(resp).orElse(new ServiceResp<T>()).getData());
    }

}
