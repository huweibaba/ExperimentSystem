package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.entity.Classroom;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.Teacher;
import com.byk.experimentsystem.service.PersonalSetting;
import com.byk.experimentsystem.util.JSRUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/personalSetting")
public class PersonalSettingController {
    @Autowired
    PersonalSetting personalSetting;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/updatePersonalMessage")
    public ResponseModel updatePersonalMessage(@Valid @RequestBody Teacher teacher, BindingResult bindingResult,HttpSession httpSession)
    {ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        if (bindingResult.hasErrors()) {
            responseModel.setParameterError(JSRUtil.getAllMessage(bindingResult));
            responseModel.setStatus(0);
            return responseModel;
        }


        try {Teacher currentTeacher =(Teacher) httpSession.getAttribute("teacher");
            teacher.setId(currentTeacher.getId());
            personalSetting.updatePersonalMessage(teacher);

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


    @CrossOrigin
    @ResponseBody
    @RequestMapping("/updateExperiment")
    public ResponseModel updateExperiment(@RequestBody Experiment experiment)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
           personalSetting.updateExperiment(experiment);
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




    @CrossOrigin
    @ResponseBody
    @RequestMapping("/updateClassroom")
    public ResponseModel updateClassroomStatus(@RequestBody Classroom classroom)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            personalSetting.updateClassroomStatus(classroom);
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
