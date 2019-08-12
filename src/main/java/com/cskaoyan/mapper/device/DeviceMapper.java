package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.Device;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 8:44 2019/8/9
 */
public interface DeviceMapper {
    List<Device> queryAllDevices();

    int insertDevice(Device device);

    List<Device> searchDeviceByDeviceId(String searchValue);

    List<Device> searchDeviceByDeviceName(String searchValue);

    List<Device> searchDeviceByDeviceTypeName(String searchValue);

    Device queryDeviceById(String deviceId);

    int updateDevice(Device device);

    int deleteDevice(String[] devices);
}
