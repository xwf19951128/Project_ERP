package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.bean.device.DeviceMaintain;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 16:11 2019/8/9
 */
public interface DeviceMaintainService {
    List<DeviceMaintain> queryAllDeviceMaintain();

    List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String searchValue);

    List<DeviceMaintain> searchDeviceMaintainByDeviceMaintainId(String searchValue);

    int updateDeviceMaintain(DeviceMaintain deviceMaintain);

    int insertDeviceMaintain(DeviceMaintain deviceMaintain);

    int deleteDeviceMaintain(String[] deviceMaintains);
}
