package com.minivision.reus.common.dto.code;

import com.minivision.common.framework.validation.annotation.NotEmpty;
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

    @NotEmpty
    private String name;

    @NotEmpty
    private String packageName;

    @NotEmpty
    private String path;

    private Boolean isGenerate;
}
