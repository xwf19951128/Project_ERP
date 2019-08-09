package com.cskaoyan.bean.qualifyMonitor;

// 工序技术质检
public class ProcessCountCheck {
    String cdate;   // 检验时间
    String checkItem;   // 检验项目
    int checkNumber; // 抽检数
    String empId;   // 检验人id
    String empName; // 检验人姓名
    String measureData; // 实际测量数据
    String note;    // 备注
    String pCountCheckId;   // 工序计数质检编号
    String processId;   // 工序编号
    double qualify; // 合格率
    String result;  // 检验结果
    int sample;  // 抽检数
    int unqualify;   // 不合格数

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
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

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getpCountCheckId() {
        return pCountCheckId;
    }

    public void setpCountCheckId(String pCountCheckId) {
        this.pCountCheckId = pCountCheckId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public double getQualify() {
        return qualify;
    }

    public void setQualify(double qualify) {
        this.qualify = qualify;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    public int getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(int unqualify) {
        this.unqualify = unqualify;
    }
}
