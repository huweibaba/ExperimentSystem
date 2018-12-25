package com.byk.experimentsystem.entity;

import java.util.Date;

public class Option_log {
    private Integer id;

    private String option;

    private String sqlStr;

    private String optTableName;

    private Date createdat;

    private Integer optUid;

    private Integer optTid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option == null ? null : option.trim();
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr == null ? null : sqlStr.trim();
    }

    public String getOptTableName() {
        return optTableName;
    }

    public void setOptTableName(String optTableName) {
        this.optTableName = optTableName == null ? null : optTableName.trim();
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Integer getOptUid() {
        return optUid;
    }

    public void setOptUid(Integer optUid) {
        this.optUid = optUid;
    }

    public Integer getOptTid() {
        return optTid;
    }

    public void setOptTid(Integer optTid) {
        this.optTid = optTid;
    }
}