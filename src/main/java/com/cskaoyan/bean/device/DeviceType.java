package com.cskaoyan.bean.device;

import java.util.Date;

/**
 * @Author: XiaoLei
 * @Date Created in 10:28 2019/8/9
 */
public class DeviceType {
    private String deviceTypeId;

    private String deviceTypeName;

    private String deviceTypeModel;

    private String deviceTypeSpec;

    private String deviceTypeSupplier;

    private String deviceTypeProducer;

    private Integer deviceTypeQuantity;

    private Date deviceTypeWarranty;

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceTypeModel() {
        return deviceTypeModel;
    }

    public void setDeviceTypeModel(String deviceTypeModel) {
        this.deviceTypeModel = deviceTypeModel;
    }

    public String getDeviceTypeSpec() {
        return deviceTypeSpec;
    }

    public void setDeviceTypeSpec(String deviceTypeSpec) {
        this.deviceTypeSpec = deviceTypeSpec;
    }

    public String getDeviceTypeSupplier() {
        return deviceTypeSupplier;
    }

    public void setDeviceTypeSupplier(String deviceTypeSupplier) {
        this.deviceTypeSupplier = deviceTypeSupplier;
    }

    public String getDeviceTypeProducer() {
        return deviceTypeProducer;
    }

    public void setDeviceTypeProducer(String deviceTypeProducer) {
        this.deviceTypeProducer = deviceTypeProducer;
    }

    public Integer getDeviceTypeQuantity() {
        return deviceTypeQuantity;
    }

    public void setDeviceTypeQuantity(Integer deviceTypeQuantity) {
        this.deviceTypeQuantity = deviceTypeQuantity;
    }

    public Date getDeviceTypeWarranty() {
        return deviceTypeWarranty;
    }

    public void setDeviceTypeWarranty(Date deviceTypeWarranty) {
        this.deviceTypeWarranty = deviceTypeWarranty;
    }

    public DeviceType() {
    }

    public DeviceType(String deviceTypeId, String deviceTypeName, String deviceTypeModel, String deviceTypeSpec, String deviceTypeSupplier, String deviceTypeProducer, Integer deviceTypeQuantity, Date deviceTypeWarranty) {
        this.deviceTypeId = deviceTypeId;
        this.deviceTypeName = deviceTypeName;
        this.deviceTypeModel = deviceTypeModel;
        this.deviceTypeSpec = deviceTypeSpec;
        this.deviceTypeSupplier = deviceTypeSupplier;
        this.deviceTypeProducer = deviceTypeProducer;
        this.deviceTypeQuantity = deviceTypeQuantity;
        this.deviceTypeWarranty = deviceTypeWarranty;
    }
}

