package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.mapper.device.DeviceFaultMapper;
import com.cskaoyan.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 15:30 2019/8/9
 */
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper mapper;

    @Override
    public List<DeviceFault> queryAllDeviceFault() {
        return mapper.queryAllDeviceFault();
    }
}
