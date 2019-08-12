package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.DeviceMaintain;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 16:13 2019/8/9
 */
public interface DeviceMaintainMapper {
    List<DeviceMaintain> queryAllDeviceMaintain();

    List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String searchValue);

    List<DeviceMaintain> searchDeviceMaintainByDeviceMaintainId(String searchValue);

    int updateDeviceMaintain(DeviceMaintain deviceMaintain);

    int insertDeviceMaintain(DeviceMaintain deviceMaintain);

    int deleteDeviceMaintain(String[] deviceMaintains);
}
