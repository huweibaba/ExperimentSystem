package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.entity.Class;
import com.byk.experimentsystem.mapper.*;
import com.byk.experimentsystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityMapper universityMapper;
    @Autowired
    CampusMapper campusMapper;
    @Autowired
    BuildingMapper buildingMapper;
    @Autowired
    ClassroomMapper classroomMapper;
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    MajorMapper majorMapper;

    @Override
    public List<University> getUniversitys() throws Exception{
        List<University> universityList=universityMapper.selectAllUniversity();
        return universityList;
    }

    @Override
    public List<Campus> getCampuses(University university) throws Exception{
        Integer unversityId=university.getId();
        List<Campus> campusList=campusMapper.selectByUniversityId(unversityId);
        return campusList;
    }

    @Override
    public List<College> getColleges(Campus campus) throws Exception {
        Integer campusId=campus.getId();
        List<College> collegeList=collegeMapper.selectByCampusId(campusId);

        return collegeList;
    }

    @Override
    public List<Major> getMajors(College college) throws Exception {
        Integer collegeId=college.getId();
        List<Major> majorList=majorMapper.selectByCollegeId(collegeId);
        return majorList;
    }

    @Override
    public List<Building> getBuildings(Campus campus) throws Exception {

        Integer campusId=campus.getId();
        List<Building> buildingList=buildingMapper.selectByCampusId(campusId);
        return buildingList;
    }

    @Override
    public List<Classroom> getClassroom(Building building) throws Exception {
        Integer buildingId=building.getId();
        List<Classroom> classroomList=classroomMapper.selectByBuildingId(buildingId);
        return classroomList;
    }

    @Override
    public List<Class> getClasses(Major major) throws Exception {
        return classMapper.selectByMajorId(major.getId());
    }




}
