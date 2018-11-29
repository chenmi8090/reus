package com.minivision.sms.main.domain.service.device.impl;

import com.minivision.common.framework.facade.exception.BusinessException;
import com.minivision.sms.main.domain.entity.device.Device;
import com.minivision.sms.main.domain.mapper.device.DeviceMapper;
import com.minivision.sms.main.domain.service.device.DeviceService;
import com.minivison.sms.api.domain.dto.device.req.DeviceReqDTO;
import com.minivison.sms.api.domain.dto.device.resp.DeviceRespDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public int add(DeviceReqDTO request) throws BusinessException {
        return deviceMapper.insert(toEntity(request));
    }

    @Override
    public int update(DeviceReqDTO request) throws BusinessException {
        return deviceMapper.updateByPrimaryKeySelective(toEntity(request));
    }

    @Override
    public int deleteById(String id) throws BusinessException {
        return deviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(List<String> id) throws BusinessException {
        Example example = new Example(DeviceReqDTO.class);
        example.createCriteria().andIn("device_id", id);

        return deviceMapper.deleteByExample(example);
    }

    @Override
    public DeviceRespDTO findById(String id) throws BusinessException {
        return toDto(deviceMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<DeviceRespDTO> query(DeviceReqDTO request) throws BusinessException {
        return toDto(deviceMapper.select(toEntity(request)));
    }

    //TODO 抽象成公共方法
    private Device toEntity(DeviceReqDTO request) {
        Device device = new Device();
        BeanUtils.copyProperties(request, device);
        return device;
    }

    //TODO 抽象成公共方法
    private DeviceRespDTO toDto(Device device) {
        DeviceRespDTO deviceRespDTO = new DeviceRespDTO();
        BeanUtils.copyProperties(device, deviceRespDTO);
        return deviceRespDTO;
    }

    //TODO 抽象成公共方法
    private List<DeviceRespDTO> toDto(List<Device> list) {
        return list.stream().map(n -> {
            DeviceRespDTO deviceRespDTO = new DeviceRespDTO();
            BeanUtils.copyProperties(n, deviceRespDTO);
            return deviceRespDTO;
        }).collect(Collectors.toList());
    }
}
