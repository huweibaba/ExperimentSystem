package com.byk.experimentsystem.Model;

import com.byk.experimentsystem.entity.Exp_commit;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class CommitModel {
    private Integer id;

    private Date createdat;

    private Date updatedat;

    private Integer step;

    private String answer;
    @Value("${fileServerIp}")
    String fileServerIp;

    String answerImgUrl;

    public CommitModel(Exp_commit exp_commit)
    {this.id=exp_commit.getId();
     this.createdat=exp_commit.getCreatedat();
     this.updatedat=exp_commit.getUpdatedat();
     this.step=exp_commit.getStep();
     this.answer=exp_commit.getAnswer();


    }

    public String getFileServerIp() {
        return fileServerIp;
    }

    public void setFileServerIp(String fileServerIp) {
        this.fileServerIp = fileServerIp;
    }

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
        this.answer = answer;
    }

    public String getAnswerImgUrl() {
        return answerImgUrl;
    }

    public void setAnswerImgUrl(String answerImgUrl) {
        this.answerImgUrl = answerImgUrl;
    }
}
