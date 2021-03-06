package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceCheck;


import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 11:25 2019/8/9
 */
public interface DeviceCheckService {
    List<DeviceCheck> queryAllDeviceCheck();

    int insertDeviceCheck(DeviceCheck deviceCheck);

    List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String searchValue);

    List<DeviceCheck> searchDeviceCheckByDeviceName(String searchValue);

    int updateDeviceCheck(DeviceCheck deviceCheck);

    int deleteDeviceCheck(String[] deviceCheck);
}
