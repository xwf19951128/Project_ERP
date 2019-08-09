package com.cskaoyan.bean.device.more;

import com.cskaoyan.bean.device.DeviceMaintain;
import org.springframework.stereotype.Repository;

/**
 * @Author: XiaoLei
 * @Date Created in 16:18 2019/8/9
 */
@Repository
public class DeviceMaintainVo extends DeviceMaintain {
    //新增一个维修人的成员变量
    private String deviceMaintainEmp;

    public String getDeviceMaintainEmp() {
        return deviceMaintainEmp;
    }

    public void setDeviceMaintainEmp(String deviceMaintainEmp) {
        this.deviceMaintainEmp = deviceMaintainEmp;
    }
}
