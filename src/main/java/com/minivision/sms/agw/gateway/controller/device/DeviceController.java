package com.minivision.sms.agw.gateway.controller.device;

import com.minivision.common.framework.validation.exception.ValidateException;
import com.minivision.common.framework.validation.util.ValidateUtil;
import com.minivision.common.framework.web.ControllerResps;
import com.minivision.common.framework.web.util.JsonUtil;
import com.minivision.sms.agw.gateway.service.device.DeviceService;
import com.minivision.sms.api.domain.dto.device.req.DeviceReqDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/device")
@Api(value = "/device", tags = "设备")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(notes = "添加设备", value = "添加设备", produces = "application/json")
    public String add(@RequestBody DeviceReqDTO request) {
        try {
            ValidateUtil.validate(request);
        } catch (ValidateException ex) {
            return JsonUtil.getErrorJson(ex.getCode(), ex.getMsg());
        }
        int result = deviceService.add(request);
        if (result > 0) {
            return ControllerResps.newSuccResp();
        } else {
            return ControllerResps.newFailResp();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(notes = "更新设备", value = "更新设备", produces = "application/json")
    public String update(@RequestBody DeviceReqDTO request) {
        try {
            ValidateUtil.validate(request);
        } catch (ValidateException ex) {
            return JsonUtil.getErrorJson(ex.getCode(), ex.getMsg());
        }
        int result = deviceService.update(request);
        if (result > 0) {
            return ControllerResps.newSuccResp();
        } else {
            return ControllerResps.newFailResp();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(notes = "删除设备", value = "删除设备", produces = "application/json")
    public String delete(@RequestBody String id) {
        if (StringUtils.isEmpty(id)) {
            return ControllerResps.paramIllegalResp();
        }

        int result = deviceService.deleteById(id);
        if (result > 0) {
            return ControllerResps.newSuccResp();
        } else {
            return ControllerResps.newFailResp();
        }
    }

    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    @ApiOperation(notes = "批量删除设备", value = "批量删除设备", produces = "application/json")
    public String batchDelete(@RequestBody List<String> id) {
        if (id == null || id.size() == 0) {
            return ControllerResps.paramIllegalResp();
        }

        int result = deviceService.batchDelete(id);
        if (result > 0) {
            return ControllerResps.newSuccResp();
        } else {
            return ControllerResps.newFailResp();
        }
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ApiOperation(notes = "查找设备", value = "删除设备", produces = "application/json")
    public String find(@RequestBody String id) {
        return ControllerResps.newSuccResp(deviceService.findById(id));
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(notes = "查询设备", value = "查询设备", produces = "application/json")
    public String queryMember(@RequestBody DeviceReqDTO request) {
        return ControllerResps.newSuccResp(deviceService.query(request));
    }
}
