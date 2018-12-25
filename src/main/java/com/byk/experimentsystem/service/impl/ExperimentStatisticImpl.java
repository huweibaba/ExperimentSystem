package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.Model.ScoreStatisticModel;
import com.byk.experimentsystem.Model.StuActionStatisticModel;
import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.entity.Class;
import com.byk.experimentsystem.mapper.Exp_commitMapper;
import com.byk.experimentsystem.mapper.Exp_reservationMapper;
import com.byk.experimentsystem.mapper.Exp_scoreMapper;
import com.byk.experimentsystem.mapper.SignMapper;
import com.byk.experimentsystem.service.ExperimentStatistic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.byk.experimentsystem.util.*;
import org.springframework.stereotype.Service;

@Service
public class ExperimentStatisticImpl implements ExperimentStatistic {
    @Autowired
    Exp_scoreMapper exp_scoreMapper;
    @Autowired
    Exp_reservationMapper exp_reservationMapper;
    @Autowired
    SignMapper signMapper;
   @Autowired
   Exp_commitMapper exp_commitMapper;

    @Override
    public ScoreStatisticModel getScoreOfClass(Experiment experiment, Class class1) throws Exception {

        List<Exp_score> scoreList = exp_scoreMapper.selectByClass(class1.getId(),experiment.getId());
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("低于60", 0);
        map.put("60-80", 0);
        map.put("80-90", 0);
        map.put("90-100", 0);

        for (Exp_score exp_score : scoreList) {
            if (exp_score.getScore() < 60)
                map.put("低于60", map.get("低于60") + 1);
            else if(exp_score.getScore()<80)
                map.put("60-80",map.get("60-80")+1);
            else if(exp_score.getScore()<90)
                map.put("80-90",map.get("80-90")+1);
            else
                map.put("90-100",map.get("90-100")+1);
        }
        Integer averageScore=ActionForecastUtil.average(scoreList);
        ScoreStatisticModel scoreStatisticModel=new ScoreStatisticModel();
        scoreStatisticModel.setAverageScore(averageScore);
        scoreStatisticModel.setMap(map);
        return scoreStatisticModel;
    }

    @Override
    public ScoreStatisticModel getScoreOfGrade(Experiment experiment) throws Exception {
        List<Exp_score> scoreList=exp_scoreMapper.selectByExpId(experiment.getId());
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("低于60", 0);
        map.put("60-80", 0);
        map.put("80-90", 0);
        map.put("90-100", 0);

        for (Exp_score exp_score : scoreList) {
            if (exp_score.getScore() < 60)
                map.put("低于60", map.get("低于60") + 1);
            else if(exp_score.getScore()<80)
                map.put("60-80",map.get("60-80")+1);
            else if(exp_score.getScore()<90)
                map.put("80-90",map.get("80-90")+1);
            else
                map.put("90-100",map.get("90-100")+1);
        }
        Integer averageScore=ActionForecastUtil.average(scoreList);
        ScoreStatisticModel scoreStatisticModel=new ScoreStatisticModel();
        scoreStatisticModel.setAverageScore(averageScore);
        scoreStatisticModel.setMap(map);
        return scoreStatisticModel;

    }

    @Override
    public StuActionStatisticModel getStuScoreParse(User user) throws Exception {
        StuActionStatisticModel stuActionStatisticModel=new StuActionStatisticModel();
        stuActionStatisticModel.setReservationCount(exp_reservationMapper.selectCountByUser(user.getId()));
        stuActionStatisticModel.setSignCount(signMapper.selectCountByUser(user.getId()));
        stuActionStatisticModel.setSubmitCount(exp_commitMapper.selectExpCount(user.getId()));
        List<Exp_score> scoreList=exp_scoreMapper.selectByUser(user);
        Integer maxScore=scoreList.get(0).getScore();
        Integer minScore=scoreList.get(0).getScore();
        Integer averageScore=0;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("低于60", 0);
        map.put("60-80", 0);
        map.put("80-90", 0);
        map.put("90-100", 0);
        for (Exp_score exp_score : scoreList) {
            if (exp_score.getScore() < 60)
                map.put("低于60", map.get("低于60") + 1);
            else if(exp_score.getScore()<80)
                map.put("60-80",map.get("60-80")+1);
            else if(exp_score.getScore()<90)
                map.put("80-90",map.get("80-90")+1);
            else
                map.put("90-100",map.get("90-100")+1);


            if(exp_score.getScore()>maxScore)
                maxScore=exp_score.getScore();
            if(exp_score.getScore()<minScore)
                minScore=exp_score.getScore();
            averageScore=averageScore+exp_score.getScore();

        }
        averageScore=averageScore/scoreList.size();
        Experiment maxScoreAt=exp_scoreMapper.selectExpByScore(maxScore);
        Experiment minScoreAt=exp_scoreMapper.selectExpByScore(minScore);
        stuActionStatisticModel.setAverageScore(averageScore);
        stuActionStatisticModel.setMaxScore(maxScore);
        stuActionStatisticModel.setMinScore(minScore);
        stuActionStatisticModel.setMaxScoreAt(maxScoreAt);
        stuActionStatisticModel.setMinScoreAt(minScoreAt);
        stuActionStatisticModel.setScoreCount(map);


        return stuActionStatisticModel;
    }
}
