package com.minivision.reus.common.controller.code;

import com.minivision.reus.common.dto.code.CodeDTO;
import com.minivision.reus.common.dto.req.GetTableNameReq;
import com.minivision.reus.common.dto.resp.ClassAndPackageResp;
import com.minivision.reus.common.service.code.CodeService;
import com.minivision.reus.common.service.other.PackageAndClassService;
import com.minivision.reus.common.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月29日 <br>
 */

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/code")
@Api(value = "/code", tags = "代码生成器")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @Resource
    private PackageAndClassService packageAndClassService;

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ApiOperation(notes = "代码生成", value = "代码生成", produces = "application/json")
    public String generate(@RequestBody CodeDTO request) {
        return "";
    }

    @RequestMapping("/getPackageAndClass")
    @ApiOperation(notes = "根据表名获取包名类名", value = "代码生成", produces = "application/json")
    public String getPackageAndClass(@RequestBody GetTableNameReq getTableNameReq) {
        ClassAndPackageResp classAndPackageResp = packageAndClassService.getPackageAndClassByTableName(getTableNameReq.getTableName());
        return JsonUtil.getSucc4Date(classAndPackageResp);
    }

}
