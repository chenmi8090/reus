package com.minivision.sms.agw.gateway.service.device.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.minivision.sms.api.domain.facade.device.DeviceFacade;
import com.minivision.sms.agw.gateway.service.device.DeviceService;
import com.minivison.sms.api.domain.dto.device.req.DeviceReqDTO;
import com.minivison.sms.api.domain.dto.device.resp.DeviceRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Reference
    private DeviceFacade deviceFacade;

    @Override
    public int add(DeviceReqDTO request) {
        return deviceFacade.add(request).getData();
    }

    @Override
    public int update(DeviceReqDTO request) {
        return deviceFacade.update(request).getData();
    }

    @Override
    public int deleteById(String id) {
        return deviceFacade.deleteById(id).getData();
    }

    @Override
    public int batchDelete(List<String> id) {
        return deviceFacade.batchDelete(id).getData();
    }

    @Override
    public DeviceRespDTO findById(String id) {
        return deviceFacade.findById(id).getData();
    }

    @Override
    public List<DeviceRespDTO> query(DeviceReqDTO request) {
        return deviceFacade.query(request).getData();
    }
}
