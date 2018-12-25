package com.byk.experimentsystem.entity;

import java.util.Date;

public class Exp_data {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer expId;

    private Integer fileUserId;

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

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public Integer getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(Integer fileUserId) {
        this.fileUserId = fileUserId;
    }
}