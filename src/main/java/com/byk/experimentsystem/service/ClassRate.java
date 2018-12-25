package com.byk.experimentsystem.service;

import com.byk.experimentsystem.Model.ClassRateModel;
import com.byk.experimentsystem.entity.Experiment;

public interface ClassRate {
    public ClassRateModel getCurrentClassRate(Experiment experiment) throws Exception;

}
