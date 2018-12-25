package com.byk.experimentsystem.service;

import com.byk.experimentsystem.entity.Classroom;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.Teacher;

public interface PersonalSetting {
    public void updatePersonalMessage(Teacher teacher) throws Exception;

    public void updateExperiment(Experiment experiment) throws Exception;

    public void updateClassroomStatus(Classroom classroom) throws Exception;
}
