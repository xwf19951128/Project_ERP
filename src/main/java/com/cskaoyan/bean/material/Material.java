package com.cskaoyan.bean.material;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Material {

    @NotNull(message = "物料编号为空")
    private String materialId;

    private String materialType;

    private String status;

    private int remaining;

    private String note;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }


    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

/*    public String getMaterialParams() {
        return materialParams;
    }

    public void setMaterialParams(String materialParams) {
        this.materialParams = materialParams;
    }*/

    @Override
    public String toString() {
        return "Material{" +
                "materialId='" + materialId + '\'' +
                ", materialType='" + materialType + '\'' +
                ", status='" + status + '\'' +
                ", remaining=" + remaining +
                ", note='" + note + '\'' +
                '}';
    }
}
