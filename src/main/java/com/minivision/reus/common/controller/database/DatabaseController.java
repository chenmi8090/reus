package com.minivision.reus.common.controller.database;

import com.minivision.reus.common.dto.database.DatabaseDTO;
import com.minivision.reus.common.service.database.DatabaseService;
import com.minivision.reus.common.util.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月29日 <br>
 */
@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping(value = "/link", method = RequestMethod.POST)
    @ApiOperation(notes = "测试连接", value = "测试连接", produces = "application/json")
    public String link(@RequestBody DatabaseDTO request) {
        return "";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    @ApiOperation(notes = "数据库连接", value = "数据库连接", produces = "application/json")
    public String connect(@RequestBody DatabaseDTO request) {
        return JsonUtil.getSucc4data(databaseService.connect(request).getData());
    }
}
