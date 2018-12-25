package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.entity.Classroom;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.Teacher;
import com.byk.experimentsystem.mapper.ClassroomMapper;
import com.byk.experimentsystem.mapper.ExperimentMapper;
import com.byk.experimentsystem.mapper.TeacherMapper;
import com.byk.experimentsystem.service.PersonalSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalSettingImpl implements PersonalSetting {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ExperimentMapper experimentMapper;

    @Autowired
    ClassroomMapper classroomMapper;
    @Override
    public void updatePersonalMessage(Teacher teacher) throws Exception {
        Teacher oldTeacher=teacherMapper.selectById(teacher.getId());

        if(!oldTeacher.getUpdatedat().toString().equals(oldTeacher.getCreatedat().toString()))
            throw new MyException("只能更改一次");


        teacherMapper.updateOne(teacher);



    }

    @Override
    public void updateExperiment(Experiment experiment) throws Exception {
        Experiment oldExperiment=experimentMapper.selectById(experiment.getId());
        if(!oldExperiment.getUpdatedat().toString().equals(oldExperiment.getCreatedat().toString()))
            throw new MyException("只能更改一次");

        experimentMapper.updateOne(experiment);


    }

    @Override
    public void updateClassroomStatus(Classroom classroom) throws Exception {
         Classroom oldClassroom=classroomMapper.selectById(classroom.getId());
        if(!oldClassroom.getUpdatedat().toString().equals(oldClassroom.getCreatedat().toString()))
            throw new MyException("只能更改一次");
        classroomMapper.updateStatus(classroom);

    }
}
