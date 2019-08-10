package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceFault;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 15:29 2019/8/9
 */
public interface DeviceFaultService {
    List<DeviceFault> queryAllDeviceFault();

    int insertDeviceFault(DeviceFault deviceFault);

    List<DeviceFault> searchDeviceFaultByDeviceFaultId(String searchValue);

    List<DeviceFault> searchDeviceFaultByDeviceFaultName(String searchValue);
}
