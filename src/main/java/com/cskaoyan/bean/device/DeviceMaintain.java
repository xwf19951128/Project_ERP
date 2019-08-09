package com.cskaoyan.bean.device;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: XiaoLei
 * @Date Created in 16:00 2019/8/9
 */
@Repository
public class DeviceMaintain {
    private String deviceMaintainId;

    private String deviceFaultId;

    private String deviceMaintainEmpId;

    private Date deviceMaintainDate;

    private String deviceMaintainResult;

    private BigDecimal deviceMaintainCost;

    private String note;

    public DeviceMaintain() {
    }

    public DeviceMaintain(String deviceMaintainId, String deviceFaultId, String deviceMaintainEmpId, Date deviceMaintainDate, String deviceMaintainResult, BigDecimal deviceMaintainCost, String note) {
        this.deviceMaintainId = deviceMaintainId;
        this.deviceFaultId = deviceFaultId;
        this.deviceMaintainEmpId = deviceMaintainEmpId;
        this.deviceMaintainDate = deviceMaintainDate;
        this.deviceMaintainResult = deviceMaintainResult;
        this.deviceMaintainCost = deviceMaintainCost;
        this.note = note;
    }

    public String getDeviceMaintainId() {
        return deviceMaintainId;
    }

    public void setDeviceMaintainId(String deviceMaintainId) {
        this.deviceMaintainId = deviceMaintainId;
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId;
    }

    public String getDeviceMaintainEmpId() {
        return deviceMaintainEmpId;
    }

    public void setDeviceMaintainEmpId(String deviceMaintainEmpId) {
        this.deviceMaintainEmpId = deviceMaintainEmpId;
    }

    public Date getDeviceMaintainDate() {
        return deviceMaintainDate;
    }

    public void setDeviceMaintainDate(Date deviceMaintainDate) {
        this.deviceMaintainDate = deviceMaintainDate;
    }

    public String getDeviceMaintainResult() {
        return deviceMaintainResult;
    }

    public void setDeviceMaintainResult(String deviceMaintainResult) {
        this.deviceMaintainResult = deviceMaintainResult;
    }

    public BigDecimal getDeviceMaintainCost() {
        return deviceMaintainCost;
    }

    public void setDeviceMaintainCost(BigDecimal deviceMaintainCost) {
        this.deviceMaintainCost = deviceMaintainCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
