package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.Device;
import com.cskaoyan.util.JsonFindResult;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 21:18 2019/8/8
 */
public interface DeviceListService {


    List<Device> queryAllDevices();
}
