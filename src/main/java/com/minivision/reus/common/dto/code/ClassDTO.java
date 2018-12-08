package com.minivision.reus.common.dto.code;

import lombok.Getter;
import lombok.Setter;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月29日 <br>
 */
@Setter
@Getter
public class ClassDTO {
    private String name;

    private String packageName;

    private String path;

    private Boolean isGenerate;
}
