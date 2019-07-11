package com.minivision.reus.common.constants;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019年01月15日 <br>
 */
public class ReusConstants {
    /**
     * 私有构造方法
     */
    private ReusConstants() {
    }

    /**
     * 系统错误code<br>
     */
    public static final String SYS_ERROR = "10000";

    /**
     * 操作成功code<br>
     */
    public static final String OPER_SUCC = "10001";

    /**
     * 操作失败code<br>
     */
    public static final String OPER_FAIL = "10002";

    /**
     * 操作异常code<br>
     */
    public static final String OPER_EXCEPTION = "10003";

    /**
     * 参数异常code<br>
     */
    public static final String PARAM_EXCEPTION = "10004";

    /**
     * 未登录或登录超时code<br>
     */
    public static final String LOGIN_TIMEOUT = "10005";

    /**
     * 未授权，请联系管理员code<br>
     */
    public static final String ACC_UNAUTHORIZED = "10006";

    /**
     * json不合法
     */
    public static final String JSON_ILLEGAL = "300010001";

    /**
     * 数据库连接错误
     */
    public static final String DATABASE_CONNECT_ERROR = "90001";

    /**
     * 数据库执行错误
     */
    public static final String DATABASE_EXECUTE_ERROR = "90002";

    /**
     * 数据可能失效
     */
    public static final String DATABASE_DATA_ERROR = "90003";

    /**
     * 生成文件路径不能为空
     */
    public static final String GENERATE_URL_IS_NOT_EMPTY = "90004";

    /**
     * 代码生成失败
     */
    public static final String GENERATE_CODE_ERROR = "90005";

    /**
     * 最少选一样进行生成
     */
    public static final String LESS_GENERATE_CODE = "90006";

    /**
     * 路径不存在
     */
    public static final String DIRECTORY_ERROR = "10009";
}
