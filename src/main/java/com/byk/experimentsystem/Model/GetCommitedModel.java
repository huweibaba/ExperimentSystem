package com.byk.experimentsystem.Model;

import com.byk.experimentsystem.entity.User;

import java.util.List;

public class GetCommitedModel
{
  User user;
  List<CommitModel> list;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CommitModel> getList() {
        return list;
    }

    public void setList(List<CommitModel> list) {
        this.list = list;
    }


}
