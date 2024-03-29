package com.minivision.reus.common.service.database.impl;

import com.minivision.plus.core.toolkit.CollectionUtils;
import com.minivision.reus.common.constants.ReusConstants;
import com.minivision.reus.common.dto.database.DatabaseDTO;
import com.minivision.reus.common.service.database.DatabaseService;
import com.minivision.reus.common.util.DbUtil;
import com.minivision.reus.common.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @CreateDate 2018年11月30日 <br>
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Override
    public String connect(DatabaseDTO request) {
        List<String> tableList;
        try {
            tableList = DbUtil.getTableNames(request);
            if (CollectionUtils.isEmpty(tableList)) {
                return JsonUtil.getError(ReusConstants.DATABASE_DATA_ERROR);
            }
        } catch (ClassNotFoundException | SQLException e) {
            return JsonUtil.getError(ReusConstants.DATABASE_EXECUTE_ERROR);
        }
        return JsonUtil.getSucc(tableList);
    }
}
