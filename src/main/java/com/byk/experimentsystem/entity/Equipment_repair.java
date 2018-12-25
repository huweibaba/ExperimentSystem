package com.byk.experimentsystem.entity;

import java.util.Date;

public class Equipment_repair {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer iscomplete;

    private Integer equipmentId;

    private Integer reportedUid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Integer getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Integer iscomplete) {
        this.iscomplete = iscomplete;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getReportedUid() {
        return reportedUid;
    }

    public void setReportedUid(Integer reportedUid) {
        this.reportedUid = reportedUid;
    }
}