package com.minivision.reus.common.dto.database;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
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
    //0:MySQL, 1:MySQL_v8 ,2:Oracle, 3:IBM DB2, 4:PostgreSQL, 5:SQL_Server, 6:Sqllite
    @NotEmpty
    private String databaseType;

    @NotEmpty
    private String hostName;

    @NotNull
    private Integer port;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String database;

    @NotEmpty
    private String encoding;


}
