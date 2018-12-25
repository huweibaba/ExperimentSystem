package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.Model.StuActionStatisticModel;
import com.byk.experimentsystem.Model.TestQuestions;
import com.byk.experimentsystem.entity.User;
import com.byk.experimentsystem.service.ActionForecast;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/actionForecast")
public class ActionForecastController {
    @Autowired
    ActionForecast actionForecast;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/scoreForecast")
    public ResponseModel scoreForecast(@RequestBody User user)
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            Map map=actionForecast.scoreForecast(user);
            responseModel.setData(map);
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
    @RequestMapping("/forecastQuestions")
    public ResponseModel forecastQuestions()
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            TestQuestions testQuestions=actionForecast.forecastQuestions();
            responseModel.setData(testQuestions);
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
