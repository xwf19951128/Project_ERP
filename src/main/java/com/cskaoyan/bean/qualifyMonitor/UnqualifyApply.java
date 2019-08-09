package com.cskaoyan.bean.qualifyMonitor;

public class UnqualifyApply {

    String unqualifyApplyId;    // 不合格产品申请编号
    String productId;   // 产品id
    String productName; // 产品名称
    String unqualifyItem;   // 不合格项目
    int unqualifyCount; // 不合格数量
    String assemblyDate;    // 加工时间
    String empId;   // 员工ID
    String empName; // 员工姓名
    String applyDate;   // 申请时间
    String note;    // 备注



    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnqualifyItem() {
        return unqualifyItem;
    }

    public void setUnqualifyItem(String unqualifyItem) {
        this.unqualifyItem = unqualifyItem;
    }

    public int getUnqualifyCount() {
        return unqualifyCount;
    }

    public void setUnqualifyCount(int unqualifyCount) {
        this.unqualifyCount = unqualifyCount;
    }

    public String getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(String assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
