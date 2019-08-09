package com.cskaoyan.bean.technology;

import java.util.Date;

public class TechnologyRequirement {
    String addTime;
    String reviseTime;
    String requirement;
    String technologyId;
    String technologyName;
    String technologyRequirementId;

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(String reviseTime) {
        this.reviseTime = reviseTime;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId;
    }


    @Override
    public String toString() {
        return "TechnologyRequirement{" +
                "addTime=" + addTime +
                ", reviseTime=" + reviseTime +
                ", requirement='" + requirement + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", technologyName='" + technologyName + '\'' +
                ", technologyRequirementId='" + technologyRequirementId + '\'' +
                '}';
    }
}
