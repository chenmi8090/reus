/**************************************************************************************** 
           南京小视科技有限公司           
 ****************************************************************************************/
package com.minivision.reus.common.dto.resp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <Description> 返回结果封装<br>
 * 
 * @author quss<br>
 * @version 1.0<br>
 * @param <E>
 * @taskId <br>
 * @CreateDate 2016年11月23日 <br>
 */
@Getter
@Setter
@ToString
public class ResultInfo<E> {

    /**
     * 是否成功
     */
    private int code;

    /**
     * 结果消息
     */
    private List<RtnMessage> msg;

    /**
     * 返回信息
     */
    private E data;

    /**
     * Description: 构造
     * 
     * @param code <br>
     * @param msg <br>
     * @param data <br>
     */
    public ResultInfo(int code, List<RtnMessage> msg, E data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * Description: 构造
     * 
     * @param code <br>
     * @param msg <br>
     */
    @SuppressWarnings("unchecked")
    public ResultInfo(int code, List<RtnMessage> msg) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = (E) new Object();
    }

    /**
     * Description: 构造
     * 
     * @param code <br>
     * @param data <br>
     */
    public ResultInfo(int code, E data) {
        super();
        this.code = code;
        this.msg = new ArrayList<>();
        this.data = data;
    }

    /**
     * Description: 构造
     * 
     * @param code <br>
     * @param rtnMsg <br>
     */
    @SuppressWarnings("unchecked")
    public ResultInfo(int code, RtnMessage rtnMsg) {
        super();
        this.code = code;
        this.msg = Collections.singletonList(rtnMsg);
        this.data = (E) new Object();
    }

    /**
     * 构造
     * 
     * @param result 返回结果
     * @param rtnMsg 返回提示信息
     * @param data 返回数据
     */
    public ResultInfo(int result, RtnMessage rtnMsg, E data) {
        super();
        this.code = result;
        this.msg = Collections.singletonList(rtnMsg);
        this.data = data;
    }

}
