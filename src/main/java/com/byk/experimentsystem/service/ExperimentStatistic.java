package com.byk.experimentsystem.service;

import com.byk.experimentsystem.Model.ScoreStatisticModel;
import com.byk.experimentsystem.Model.StuActionStatisticModel;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.User;

public interface ExperimentStatistic {
    public ScoreStatisticModel getScoreOfClass(Experiment experiment, com.byk.experimentsystem.entity.Class class1) throws Exception;
    public ScoreStatisticModel getScoreOfGrade(Experiment experiment) throws Exception;
    public StuActionStatisticModel getStuScoreParse(User user) throws  Exception;
}
