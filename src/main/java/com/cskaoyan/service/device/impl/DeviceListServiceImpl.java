package com.cskaoyan.service.device.impl;


import com.cskaoyan.bean.device.Device;
import com.cskaoyan.mapper.device.DeviceMapper;
import com.cskaoyan.service.device.DeviceListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * @Author: XiaoLei
 * @Date Created in 21:15 2019/8/8
 */
@Service
public class DeviceListServiceImpl implements DeviceListService {

    @Autowired
    DeviceMapper mapper;

    @Override
    public List<Device> queryAllDevices() {
        return mapper.queryAllDevices();
    }
}
