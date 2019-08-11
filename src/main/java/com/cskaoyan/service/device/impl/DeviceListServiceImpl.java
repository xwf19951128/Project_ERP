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

    @Override
    public int insertDevice(Device device) {
        Device device1= mapper.queryDeviceById(device.getDeviceId());
        if(device1!=null){
            return 2;
        }
        return mapper.insertDevice(device);
    }

    @Override
    public List<Device> searchDeviceByDeviceId(String searchValue) {
        return mapper.searchDeviceByDeviceId(searchValue);
    }

    @Override
    public List<Device> searchDeviceByDeviceName(String searchValue) {
        return mapper.searchDeviceByDeviceName(searchValue);
    }

    @Override
    public List<Device> searchDeviceByDeviceTypeName(String searchValue) {
        return mapper.searchDeviceByDeviceTypeName(searchValue);
    }

    @Override
    public int updateDevice(Device device) {
        return mapper.updateDevice(device);
    }

    @Override
    public int deleteDevice(String[] devices) {
        return mapper.deleteDevice(devices);
    }
}
