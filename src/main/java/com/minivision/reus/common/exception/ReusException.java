package com.minivision.reus.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * <Description> 自定义异常<br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年4月5日 <br>
 */
@Setter
@Getter
public class ReusException extends RuntimeException {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 代码
     */
    private final String code;

    /**
     * 信息
     */
    private final String msg;

    /**
     * 构造函数
     * @param code <br>
     */
    public ReusException(String code) {
        super(code);
        this.code = code;
        //this.msg = ResourceUtil.getMessage(code);
        this.msg = "";

    }

    /**
     * 构造函数
     * @param code <br>
     * @param params <br>
     */
    public ReusException(String code, Object... params) {
        super(code + "|");
        this.code = code;
        this.msg = "";

    }

    /**
     * 构造函数
     *
     * @param code <br>
     * @param msg <br>
     */
    public ReusException(String code, String msg) {
        super(code + "|" + msg);
        this.code = code;
        this.msg = msg;
    }

}
