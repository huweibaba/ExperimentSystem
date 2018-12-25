package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.PageModel;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.Model.ScoreStatisticModel;
import com.byk.experimentsystem.Model.StuActionStatisticModel;
import com.byk.experimentsystem.entity.Class;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.Teacher;
import com.byk.experimentsystem.entity.User;
import com.byk.experimentsystem.service.ExperimentStatistic;
import com.byk.experimentsystem.util.JSONUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/experimentStatistic")
public class ExperimentStatisticController {
    @Autowired
    ExperimentStatistic experimentStatistic;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("getScoreOfClass")
    public ResponseModel getScoreOfClass(@RequestBody Map<String,Object> map)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            Experiment experiment= JSONUtil.parseMap((Map<String, Object>) map.get("experiment"),Experiment.class);
            Class class1=JSONUtil.parseMap((Map<String, Object>) map.get("class1"),Class.class);
            ScoreStatisticModel scoreStatisticModel=experimentStatistic.getScoreOfClass(experiment,class1);
            responseModel.setData(scoreStatisticModel);

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
    @RequestMapping("getScoreOfGrade")
    public ResponseModel getScoreOfGrade(@RequestBody Experiment experiment)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
           ScoreStatisticModel scoreStatisticModel=experimentStatistic.getScoreOfGrade(experiment);
           responseModel.setData(scoreStatisticModel);
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
    @RequestMapping("getStuScoreParse")
    public ResponseModel getStuScoreParse(@RequestBody User user)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            StuActionStatisticModel stuActionStatisticModel=experimentStatistic.getStuScoreParse(user);
            responseModel.setData(stuActionStatisticModel);
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
