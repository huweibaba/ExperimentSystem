package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.RegisterModel;
import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.mapper.*;
import com.byk.experimentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TeacherMapper teacherMapper;


    public Teacher login(Teacher teacher) throws Exception{
       Integer teaId=teacher.getTeaId();
       String password=teacher.getPassword();
       //如果用户昵称不存在，就抛出自定义异常，异常信息为用户名不存在
        Teacher queryTeacher=teacherMapper.selectByTeaId(teacher.getTeaId());
        if(queryTeacher==null) throw new MyException("教工号不存在");
        queryTeacher=teacherMapper.queryUser(teaId, password);
        if(queryTeacher==null) throw new MyException("密码错误");
        return queryTeacher;

    }

    @Override
    public void register(Teacher teacher) throws Exception{
        //如果该教工号已经被绑定，那么就抛出自定义异常，异常信息为学号已经绑定。否则向数据库中增加新用户信息。
        Teacher isExisted=teacherMapper.queryTeacherByTeaId(teacher.getTeaId());
        if(isExisted!=null)
            throw new MyException("该学号已被绑定");
        else
            teacherMapper.insert(teacher);
    }





}



