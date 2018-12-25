package com.byk.experimentsystem.entity;

import java.util.Date;

public class Study_reservation {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer classroomId;

    private Integer reservedUid;

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

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getReservedUid() {
        return reservedUid;
    }

    public void setReservedUid(Integer reservedUid) {
        this.reservedUid = reservedUid;
    }
}