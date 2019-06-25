package com.minivision.reus.common.service.code;

import com.minivision.reus.common.dto.code.CodeDTO;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月29日 <br>
 */
public interface CodeService {

    String generate(CodeDTO codeDTO);

}
