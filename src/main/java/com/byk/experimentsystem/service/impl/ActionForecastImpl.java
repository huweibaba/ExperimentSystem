package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.Model.TestQuestions;
import com.byk.experimentsystem.entity.Exp_score;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.User;
import com.byk.experimentsystem.mapper.Exp_scoreMapper;
import com.byk.experimentsystem.mapper.ExperimentMapper;
import com.byk.experimentsystem.service.ActionForecast;
import com.byk.experimentsystem.util.ActionForecastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ActionForecastImpl implements ActionForecast {

    @Autowired
    Exp_scoreMapper exp_scoreMapper;
    @Autowired
    ExperimentMapper experimentMapper;
    @Override
    public Map scoreForecast(User user) throws Exception {
        Map resultMap=new HashMap();
        Integer forecastScore;
        List<Map> scoreList=new ArrayList<Map>();
      List<Exp_score> stuScoreList=exp_scoreMapper.selectByUser(user);
      for(Exp_score exp_score:stuScoreList)
      {   Map map=new HashMap();
          Integer expRid=exp_score.getExpRid();
          List<Exp_score> expScoreList=exp_scoreMapper.selectByExpRid(expRid);
          Integer averageScore= ActionForecastUtil.average(expScoreList);
          map.put("stuScoreMessage",exp_score);
          map.put("averageScore",averageScore);
          scoreList.add(map);
      }
      forecastScore=ActionForecastUtil.scoreForecast(scoreList);
      resultMap.put("scoreList",scoreList);
      resultMap.put("forecastScore",forecastScore);


        return resultMap;
    }


    @Override
    public TestQuestions forecastQuestions() throws Exception {

        List<Experiment> experimentList=experimentMapper.selectAll();
        List<Map> parametr=new ArrayList<Map>();
        for(Experiment experiment:experimentList)
        {
            List<Exp_score> scoreList=exp_scoreMapper.selectByExpId(experiment.getId());
            Integer average=ActionForecastUtil.average(scoreList);
            Map map=new HashMap();
            map.put("expName",experiment.getName());
            map.put("averageScore",average);
            parametr.add(map);


        }
        TestQuestions testQuestions=ActionForecastUtil.forecastQuestions(parametr);
        return testQuestions;
    }
}
