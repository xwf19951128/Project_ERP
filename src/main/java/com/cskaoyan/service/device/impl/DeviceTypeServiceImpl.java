package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceType;
import com.cskaoyan.mapper.device.DeviceMapper;
import com.cskaoyan.mapper.device.DeviceTypeMapper;
import com.cskaoyan.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 10:45 2019/8/9
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper mapper;

    @Override
    public List<DeviceType> queryAllDeviceType() {
        return mapper.queryAllDeviceType();
    }
}
