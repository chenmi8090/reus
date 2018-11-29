package com.minivision.sms.main.domain.service.device;

import com.minivision.common.framework.facade.exception.BusinessException;
import com.minivison.sms.api.domain.dto.device.req.DeviceReqDTO;
import com.minivison.sms.api.domain.dto.device.resp.DeviceRespDTO;

import java.util.List;

public interface DeviceService {

    int add(DeviceReqDTO request) throws BusinessException;

    int update(DeviceReqDTO request) throws BusinessException;

    int deleteById(String id) throws BusinessException;

    int batchDelete(List<String> id) throws BusinessException;

    DeviceRespDTO findById(String id) throws BusinessException;

    List<DeviceRespDTO> query(DeviceReqDTO request) throws BusinessException;
}
