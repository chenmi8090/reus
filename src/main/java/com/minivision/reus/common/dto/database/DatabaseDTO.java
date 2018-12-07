package com.minivision.reus.common.dto.database;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月30日 <br>
 */
@Setter
@Getter
public class DatabaseDTO implements Serializable {
    //0:mysql, 1:mysql_v8 ,2:Oracle, 3:IBM DB2, 4:PostgreSQL, 5:SQL_Server, 6:Sqllite
    private Integer dbType;

    private String ip;

    private Integer port;

    private String user;

    private String pwd;

    private String database;

    private String encoding;


}
