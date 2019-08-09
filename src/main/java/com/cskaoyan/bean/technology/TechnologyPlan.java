package com.cskaoyan.bean.technology;

import java.sql.Timestamp;
import java.util.Date;

public class TechnologyPlan {
    String technologyName;
    String technologyId;
    String technologyPlanId;
    int batchAmount;
    String commitPlan;
    String endPlan;
    String startPlan;
    String technologyPlanEnd;
    String technologyPlanStart;

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

    public String getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(String commitPlan) {
        this.commitPlan = commitPlan;
    }

    public String getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(String endPlan) {
        this.endPlan = endPlan;
    }

    public String getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(String startPlan) {
        this.startPlan = startPlan;
    }

    public String getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(String technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }

    public String getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(String technologyPlanStart) {
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
