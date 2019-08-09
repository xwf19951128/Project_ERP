package com.cskaoyan.bean.device.more;

import com.cskaoyan.bean.device.DeviceFault;
import org.springframework.stereotype.Repository;

/**
 * @Author: XiaoLei
 * @Date Created in 15:43 2019/8/9
 */
@Repository
public class DeviceFaultVo extends DeviceFault {
    //新增的属性
    private String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
