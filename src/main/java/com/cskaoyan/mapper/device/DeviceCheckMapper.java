package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.DeviceCheck;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 11:28 2019/8/9
 */
public interface DeviceCheckMapper {
    List<DeviceCheck> queryAllDeviceCheck();

    List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String searchValue);

    List<DeviceCheck> searchDeviceCheckByDeviceName(String searchValue);
}
