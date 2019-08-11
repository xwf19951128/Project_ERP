package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceType;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 10:44 2019/8/9
 */
public interface DeviceTypeService {
    List<DeviceType> queryAllDeviceType();

    int insertDeviceType(DeviceType deviceType);

    int deleteDeviceType(String[] deviceTypes);

    int updateDeviceType(DeviceType deviceType);

    List<DeviceType> queryDeviceTypeByDeviceTypeId(String searchValue);

    List<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue);
}
