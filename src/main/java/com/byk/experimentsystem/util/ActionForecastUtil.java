package com.byk.experimentsystem.util;

import com.byk.experimentsystem.Model.TestQuestions;
import com.byk.experimentsystem.entity.Exp_score;

import java.util.List;
import java.util.Map;

public class ActionForecastUtil {
    public static Integer scoreForecast(List<Map> scoreList)
    {//此处填写分数预测算法代码
        return 0;
    }

    public static Integer average(List<Exp_score> expScoreList)
    {   int sum=0;
        for(int i=0;i<expScoreList.size();i++)
        {
            sum=sum+expScoreList.get(i).getScore();
        }
        if(expScoreList.size()>0)
        return sum/expScoreList.size();
        else
            return null;
    }

    public static TestQuestions forecastQuestions(List<Map> parameter)
    {
        return null;
    }
}
