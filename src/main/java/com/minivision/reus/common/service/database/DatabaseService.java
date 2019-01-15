package com.minivision.reus.common.service.database;

import com.minivision.reus.common.dto.database.DatabaseDTO;
import com.minivision.reus.common.dto.resp.ServiceResp;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月30日 <br>
 */
public interface DatabaseService {
    ServiceResp<List<String>> connect(DatabaseDTO request);
}
