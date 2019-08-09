package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceMaintain;
import com.cskaoyan.mapper.device.DeviceMaintainMapper;
import com.cskaoyan.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 16:11 2019/8/9
 */
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper mapper;
    @Override
    public List<DeviceMaintain> queryAllDeviceMaintain() {
        return mapper.queryAllDeviceMaintain();
    }
}
