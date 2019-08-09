package com.cskaoyan.bean.device;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: XiaoLei
 * @Date Created in 15:19 2019/8/9
 */
@Repository
public class DeviceFault {
    private String deviceFaultId;

    private String deviceId;

    private String deviceFaultCause;

    private String deviceFaultDetail;

    private Date deviceFaultDate;

    private String deviceFaultMaintenance;

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause;
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail;
    }

    public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance;
    }
}
