package com.cskaoyan.bean.device.more;

import com.cskaoyan.bean.device.Device;
import com.cskaoyan.bean.device.DeviceCheck;
import org.springframework.stereotype.Repository;

/**
 * @Author: XiaoLei
 * @Date Created in 14:54 2019/8/9
 */
@Repository
public class DeviceCheckVo extends DeviceCheck {
    //比DeviceCheck多出的成员变量
    private String deviceName;
    private String deviceCheckEmp;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp;
    }
}
