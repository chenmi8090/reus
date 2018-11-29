package com.minivision.sms.api.domain.facade.device.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.minivision.sms.api.domain.facade.device.DeviceFacade;
import com.minivision.common.framework.facade.FacadeResp;
import com.minivision.common.framework.facade.FacadeResps;
import com.minivision.common.framework.facade.exception.BusinessException;
import com.minivision.sms.main.domain.service.device.DeviceService;
import com.minivision.sms.api.domain.dto.device.req.DeviceReqDTO;
import com.minivision.sms.api.domain.dto.device.resp.DeviceRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Service
@Component
public class DeviceFacadeImpl implements DeviceFacade {


    @Autowired
    private DeviceService deviceService;

    @Override
    public FacadeResp<Integer> add(DeviceReqDTO request) {
        try {
           return FacadeResps.newSuccessResp(deviceService.add(request));
        } catch (BusinessException e) {
            return FacadeResps.newResp(e.getCode());
        } catch (Exception e) {
            return FacadeResps.newErrorResp();
        }
    }

    @Override
    public FacadeResp<Integer> update(DeviceReqDTO request) {
        try {
            return FacadeResps.newSuccessResp(deviceService.update(request));
        } catch (BusinessException e) {
            return FacadeResps.newResp(e.getCode());
        } catch (Exception e) {
            return FacadeResps.newErrorResp();
        }
    }

    @Override
    public FacadeResp<Integer> deleteById(String id) {
        try {
            return FacadeResps.newSuccessResp(deviceService.deleteById(id));
        } catch (BusinessException e) {
            return FacadeResps.newResp(e.getCode());
        } catch (Exception e) {
            return FacadeResps.newErrorResp();
        }
    }

    @Override
    public FacadeResp<Integer> batchDelete(List<String> id) {
        try {
            return FacadeResps.newSuccessResp(deviceService.batchDelete(id));
        } catch (BusinessException e) {
            return FacadeResps.newResp(e.getCode());
        } catch (Exception e) {
            return FacadeResps.newErrorResp();
        }
    }

    @Override
    public FacadeResp<DeviceRespDTO> findById(String id) {
        try {
            return FacadeResps.newSuccessResp(deviceService.findById(id));
        } catch (BusinessException e) {
            return FacadeResps.newResp(e.getCode());
        } catch (Exception e) {
            return FacadeResps.newErrorResp();
        }
    }

    @Override
    public FacadeResp<List<DeviceRespDTO>> query(DeviceReqDTO query) {
        try {
            return FacadeResps.newSuccessResp(deviceService.query(query));
        } catch (BusinessException e) {
            return FacadeResps.newResp(e.getCode());
        } catch (Exception e) {
            return FacadeResps.newErrorResp();
        }
    }
}
