package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.Device;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 8:44 2019/8/9
 */
public interface DeviceMapper {
    List<Device> queryAllDevices();
}
