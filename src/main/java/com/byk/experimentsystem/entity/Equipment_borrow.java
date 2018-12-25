package com.byk.experimentsystem.entity;

import java.util.Date;

public class Equipment_borrow {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer equipmentId;

    private Integer userId;

    private Date borrowTime;

    private Date returnTime;

    private Integer iscomfirm;

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

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getIscomfirm() {
        return iscomfirm;
    }

    public void setIscomfirm(Integer iscomfirm) {
        this.iscomfirm = iscomfirm;
    }
}