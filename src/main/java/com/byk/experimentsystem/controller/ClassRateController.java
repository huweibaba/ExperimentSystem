package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.ClassRateModel;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.Model.TestQuestions;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.service.ClassRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/classRate")
public class ClassRateController {

    @Autowired
    ClassRate classRate;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getCurrentClassRate")
    public ResponseModel getCurrentClassRate(@RequestBody Experiment experiment)
    { ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            ClassRateModel classRateModel=classRate.getCurrentClassRate(experiment);
            responseModel.setData(classRateModel);
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
