/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.dto.code;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import lombok.Data;

import java.io.Serializable;

/**
 * <Description>: DataSourceDto<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/06/24
 */
@Data
public class DataSourceDto implements Serializable {

    /**
     * 连接名
     */
    @NotEmpty
    private String linkName;

    /**
     * 数据库类型
     */
    @NotEmpty
    private String dbType;

    /**
     * 连接地址
     */
    @NotEmpty
    private String linkUrl;

    /**
     * 连接端口
     */
    @NotEmpty
    private String linkPort;

    /**
     * 连接用户名
     */
    @NotEmpty
    private String linkUserName;

    /**
     * 连接密码
     */
    @NotEmpty
    private String linkPassWord;

    /**
     * 连接的数据库名称
     */
    @NotEmpty
    private String linkDbName;

    /**
     * 编码集
     */
    @NotEmpty
    private String enCoding;
}
