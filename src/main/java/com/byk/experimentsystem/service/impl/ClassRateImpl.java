package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.Model.ClassRateModel;
import com.byk.experimentsystem.entity.Exp_reservation;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.mapper.Exp_reservationMapper;
import com.byk.experimentsystem.mapper.SignMapper;
import com.byk.experimentsystem.service.ClassRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRateImpl implements ClassRate {
    @Autowired
    SignMapper signMapper;
    @Autowired
    Exp_reservationMapper exp_reservationMapper;

    @Override
    public ClassRateModel getCurrentClassRate(Experiment experiment) throws Exception {
        int needNumber=exp_reservationMapper.selectCountByExperiment(experiment);
        int realNumber=signMapper.selectCountByExperiment(experiment);
        float classRate=(float)realNumber/needNumber;
        ClassRateModel classRateModel=new ClassRateModel();
        classRateModel.setClassRate(classRate);
        classRateModel.setNeedStuNumber(needNumber);
        classRateModel.setRealStuNumber(realNumber);
        return classRateModel;
    }
}
