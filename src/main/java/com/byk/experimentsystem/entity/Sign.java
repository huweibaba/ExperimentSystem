package com.byk.experimentsystem.entity;

import java.util.Date;

public class Sign {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer expRid;

    private Integer signUid;

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

    public Integer getExpRid() {
        return expRid;
    }

    public void setExpRid(Integer expRid) {
        this.expRid = expRid;
    }

    public Integer getSignUid() {
        return signUid;
    }

    public void setSignUid(Integer signUid) {
        this.signUid = signUid;
    }
}