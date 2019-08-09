package com.cskaoyan.bean.technology;

import java.sql.Timestamp;
import java.util.Date;

public class TechnologyPlan {
    String technologyName;
    String technologyId;
    String technologyPlanId;
    int batchAmount;
    Date commitPlan;
    Date endPlan;
    Date startPlan;
    Date technologyPlanEnd;
    Date technologyPlanStart;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId;
    }

    public int getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(int batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Date getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(Date commitPlan) {
        this.commitPlan = commitPlan;
    }

    public Date getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(Date endPlan) {
        this.endPlan = endPlan;
    }

    public Date getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(Date startPlan) {
        this.startPlan = startPlan;
    }

    public Date getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(Date technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }

    public Date getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(Date technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }

    @Override
    public String toString() {
        return "TechnologyPlan{" +
                "technologyName='" + technologyName + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", technologyPlanId='" + technologyPlanId + '\'' +
                ", batchAmount=" + batchAmount +
                ", commitPlan=" + commitPlan +
                ", endPlan=" + endPlan +
                ", startPlan=" + startPlan +
                ", technologyPlanEnd=" + technologyPlanEnd +
                ", technologyPlanStart=" + technologyPlanStart +
                '}';
    }
}
