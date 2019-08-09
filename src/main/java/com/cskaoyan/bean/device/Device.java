package com.cskaoyan.bean.device;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: XiaoLei
 * @Date Created in 19:46 2019/8/8
 */
@Repository
public class Device {

    //设备编号
    private String deviceId;
    //设备名字
    private String deviceName;
    //设备类型
    private String deviceTypeId;
    //设备状态id
    private String deviceStatusId;
    //设备状态
    private String deviceStatus;
    //设备购入时间
    private Date devicePurchaseDate;
    //设备购入价格
    private BigDecimal devicePurchasePrice;
    //设备维修日期
    private Date deviceManufactureDate;
    //设备保质期
    private Date deviceServiceLife;
    //设备保管人
    private String deviceKeeperId;
    //设备概述
    private String note;

    public Device() {
    }

    public Device(String deviceId, String deviceName, String deviceTypeId, String deviceStatusId, String deviceStatus, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceManufactureDate, Date deviceServiceLife, String deviceKeeperId, String note) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceTypeId = deviceTypeId;
        this.deviceStatusId = deviceStatusId;
        this.deviceStatus = deviceStatus;
        this.devicePurchaseDate = devicePurchaseDate;
        this.devicePurchasePrice = devicePurchasePrice;
        this.deviceManufactureDate = deviceManufactureDate;
        this.deviceServiceLife = deviceServiceLife;
        this.deviceKeeperId = deviceKeeperId;
        this.note = note;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Date getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public BigDecimal getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(BigDecimal devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public Date getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(Date deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public Date getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(Date deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        note = note;
    }
}
