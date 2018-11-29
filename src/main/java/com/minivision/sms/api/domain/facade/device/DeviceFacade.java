package com.minivision.sms.api.domain.facade.device;

import com.minivision.common.framework.facade.FacadeResp;
import com.minivision.sms.api.domain.dto.device.req.DeviceReqDTO;
import com.minivision.sms.api.domain.dto.device.resp.DeviceRespDTO;

import java.util.List;

public interface DeviceFacade {

    FacadeResp<Integer> add(DeviceReqDTO request);

    FacadeResp<Integer> update(DeviceReqDTO request);

    FacadeResp<Integer> deleteById(String id);

    FacadeResp<Integer> batchDelete(List<String> id);

    FacadeResp<DeviceRespDTO> findById(String id);

    FacadeResp<List<DeviceRespDTO>> query(DeviceReqDTO query);

}
