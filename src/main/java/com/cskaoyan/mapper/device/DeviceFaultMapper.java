package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.DeviceFault;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 15:33 2019/8/9
 */
public interface DeviceFaultMapper {
    List<DeviceFault> queryAllDeviceFault();

    int insertDeviceFault(DeviceFault deviceFault);

    DeviceFault queryDeviceFaultById(String deviceFaultId);

    List<DeviceFault> searchDeviceFaultByDeviceFaultId(String searchValue);

    List<DeviceFault> searchDeviceFaultByDeviceFaultName(String searchValue);
}
