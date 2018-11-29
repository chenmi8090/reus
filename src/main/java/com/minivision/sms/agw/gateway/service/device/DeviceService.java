package com.minivision.sms.agw.gateway.service.device;

import com.minivison.sms.api.domain.dto.device.req.DeviceReqDTO;
import com.minivison.sms.api.domain.dto.device.resp.DeviceRespDTO;

import java.util.List;

public interface DeviceService {

    int add(DeviceReqDTO request);

    int update(DeviceReqDTO request);

    int deleteById(String id);

    int batchDelete(List<String> id);

    DeviceRespDTO findById(String id);

    List<DeviceRespDTO> query(DeviceReqDTO request);
}
