package com.byk.experimentsystem.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class Exp_score {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer score;

    private String comment;

    private Integer expRid;

    private Integer commentUid;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getExpRid() {
        return expRid;
    }

    public void setExpRid(Integer expRid) {
        this.expRid = expRid;
    }

    public Integer getCommentUid() {
        return commentUid;
    }

    public void setCommentUid(Integer commentUid) {
        this.commentUid = commentUid;
    }
}