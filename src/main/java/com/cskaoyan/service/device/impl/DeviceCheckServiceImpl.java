package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.mapper.device.DeviceCheckMapper;
import com.cskaoyan.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 11:26 2019/8/9
 */
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper mapper;

    @Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        return mapper.queryAllDeviceCheck();
    }

    @Override
    public int insertDeviceCheck() {
        return 0;
    }

    @Override
    public List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String searchValue) {
        return mapper.searchDeviceCheckByDeviceCheckId(searchValue);
    }

    @Override
    public List<DeviceCheck> searchDeviceCheckByDeviceName(String searchValue) {
        return mapper.searchDeviceCheckByDeviceName(searchValue);
    }
}
