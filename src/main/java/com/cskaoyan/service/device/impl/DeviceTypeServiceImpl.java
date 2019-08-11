package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceType;
import com.cskaoyan.mapper.device.DeviceMapper;
import com.cskaoyan.mapper.device.DeviceTypeMapper;
import com.cskaoyan.service.device.DeviceTypeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        //首先要进行重复id判断操作，如果数据库中有相同id，则返回true
        DeviceType deviceType1 = mapper.queryDeviceTypeById(deviceType.getDeviceTypeId());
        if(deviceType1!=null){
            return 2;
        }else {
            return mapper.insertDeviceType(deviceType);
        }
    }

    @Override
    public int deleteDeviceType(String[] deviceTypes) {
        return mapper.deleteDeviceType(deviceTypes);
    }

    @Override
    public int updateDeviceType(DeviceType deviceType) {

            return mapper.updateDeviceType(deviceType);
    }

    @Override
    public List<DeviceType> queryDeviceTypeByDeviceTypeId(String searchValue) {
        return mapper.queryDeviceTypeByDeviceTypeId(searchValue);
    }

    @Override
    public List<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue) {
        return mapper.searchDeviceTypeByDeviceTypeName(searchValue);
    }
}
