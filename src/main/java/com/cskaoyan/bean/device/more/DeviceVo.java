package com.cskaoyan.bean.device.more;

import com.cskaoyan.bean.device.Device;
import org.springframework.stereotype.Repository;

/**
 * @Author: XiaoLei
 * @Date Created in 14:24 2019/8/9
 */
@Repository
public class DeviceVo extends Device {
    //比Device多出的成员变量
    private String deviceTypeName;
    private String deviceKeeper;

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
