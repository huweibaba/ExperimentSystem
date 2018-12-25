package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.PageModel;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.Model.TeacherModel;
import com.byk.experimentsystem.entity.Course;
import com.byk.experimentsystem.entity.Major;
import com.byk.experimentsystem.entity.Teacher;
import com.byk.experimentsystem.entity.User;
import com.byk.experimentsystem.service.TeachingManagementService;
import com.byk.experimentsystem.service.UserService;
import com.byk.experimentsystem.util.JSRUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public ResponseModel login(@RequestBody TeacherModel teacherModel, HttpSession httpSession) throws Exception {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        Teacher teacher = new Teacher();
        teacher.setTeaId(teacherModel.getTeaId());
        teacher.setPassword(teacherModel.getPassword());
        try {
            Teacher responseTeacher = userService.login(teacher);
            httpSession.setAttribute("teacher",responseTeacher);
            responseModel.setData(responseTeacher);
        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");

        }
        return responseModel;
    }

    @CrossOrigin
    @RequestMapping("/register")
    @ResponseBody
    public ResponseModel register(@Valid @RequestBody TeacherModel teacherModel, BindingResult bindingResult) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        if (bindingResult.hasErrors()) {
            responseModel.setParameterError(JSRUtil.getAllMessage(bindingResult));
            responseModel.setStatus(0);
            return responseModel;
        }


        try {
            Teacher teacher=teacherModel.getTeacher();
            teacher.setIsTeacherConfirm(0);
            userService.register(teacher);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


}
