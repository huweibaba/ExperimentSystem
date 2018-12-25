package com.byk.experimentsystem.service;

import com.byk.experimentsystem.Model.RegisterModel;
import com.byk.experimentsystem.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

//UserService接口用来定义与用户信息的增删改查和登录注册相关的操作
@Service
public interface UserService {

    public Teacher login(Teacher teacher) throws Exception;//登录接口方法
    public void register(Teacher teacher) throws Exception;//注册接口方法

}
