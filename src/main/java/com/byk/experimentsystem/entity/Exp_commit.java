package com.byk.experimentsystem.entity;

import java.util.Date;

public class Exp_commit {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer step;

    private String answer;

    private Integer answerImgId;

    private Integer expRid;

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

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getAnswerImgId() {
        return answerImgId;
    }

    public void setAnswerImgId(Integer answerImgId) {
        this.answerImgId = answerImgId;
    }

    public Integer getExpRid() {
        return expRid;
    }

    public void setExpRid(Integer expRid) {
        this.expRid = expRid;
    }
}