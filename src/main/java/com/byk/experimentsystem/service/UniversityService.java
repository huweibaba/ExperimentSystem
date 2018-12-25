package com.byk.experimentsystem.service;

import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.entity.Class;

import java.util.List;

public interface UniversityService {
    public List<University> getUniversitys() throws Exception;

    public List<Campus> getCampuses(University university) throws Exception;

    public List<College> getColleges(Campus campus) throws Exception;
    public List<Major> getMajors(College college) throws Exception;
    public List<Building> getBuildings(Campus campus) throws Exception;
    public List<Classroom> getClassroom(Building building) throws Exception;

    public List<Class> getClasses(Major major) throws Exception;
 }
