package com.byk.experimentsystem.service.impl;

import com.byk.experimentsystem.Model.*;
import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.mapper.*;
import com.byk.experimentsystem.service.TeachingManagementService;
import com.byk.experimentsystem.util.FileUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.byk.experimentsystem.Exception.MyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.*;

@Service
public class TeachingManagementServiceImpl implements TeachingManagementService{
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    ExperimentMapper experimentMapper;
    @Autowired
    UniversityMapper universityMapper;
    @Autowired
    CampusMapper campusMapper;
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    BuildingMapper buildingMapper;
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    ClassroomMapper classroomMapper;
    @Autowired
    FileUtil fileUtil;
    @Autowired
    FileMapper fileMapper;
    @Autowired
    File_userMapper file_userMapper;

    @Autowired
    Exp_dataMapper exp_dataMapper;
    @Autowired
    Exp_reservationMapper exp_reservationMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    Exp_commitMapper exp_commitMapper;

    @Autowired
    Exp_scoreMapper exp_scoreMapper;

    @Autowired
    UserMapper userMapper;


    @Override
    public void releaseCourse(Course course) throws Exception {


        courseMapper.insert(course);


    }

    @Override
    public List<Course> getCourses(Major major) throws Exception {
        Integer id=major.getId();
        List<Course> courseList=courseMapper.selectByMajorId(id);
        return courseList;

    }

    @Override
    public void releaseExperiment(Experiment experiment) throws Exception {


        experimentMapper.insert(experiment);



    }

    @Override
    public void releaseExperimentTime(Experiment experiment) throws Exception{
        experimentMapper.updateTime( experiment);
    }

    @Override
    public PageModel getNoReleaseExperiments(PageModel pageModel,Teacher currentTeacher) throws Exception {
        PageHelper.startPage(pageModel.getPageNum(),pageModel.getPageSize());
        List experimentList=experimentMapper.selectNoReleaseExperimentsByTid(currentTeacher.getId());
        PageInfo pageInfo=new PageInfo(experimentList);

        pageModel.setList(experimentList);

        pageModel.setTotal((int) pageInfo.getTotal());
        return pageModel;
    }

    @Override
    public PageModel getReleasedExperiments(PageModel pageModel,Teacher currentTeacher) throws Exception {
        PageHelper.startPage(pageModel.getPageNum(),pageModel.getPageSize());

        List experimentList=experimentMapper.selectReleasedtExperimentsByTid(currentTeacher.getId());
        PageInfo pageInfo=new PageInfo(experimentList);

        pageModel.setList(experimentList);

        pageModel.setTotal((int) pageInfo.getTotal());
        return pageModel;
    }

    @Override
    public void releaseData(MultipartFile[] multipartFiles,Experiment experiment,Teacher teacher) throws Exception {
        if(multipartFiles.length>0) {
            List<File> fileList = fileUtil.fileUpLoad(multipartFiles);

            fileMapper.insertFiles(fileList);
            List<File_user> file_userList = new ArrayList<File_user>(fileList.size());
            for (File file : fileList) {
                File_user file_user = new File_user();
                file_user.setFileId(file.getId());
                file_user.setTeacherId(teacher.getId());
                file_userList.add(file_user);
            }

            file_userMapper.insertRelations(file_userList);
            Map map = new HashMap();
            map.put("experiment", experiment);
            map.put("file_userList", file_userList);
            exp_dataMapper.insertRelations(map);
        }


    }

    @Override
    public void download(OutputStream outputStream,File file) throws Exception {
        String url=file.getFilePath();
        fileUtil.download(outputStream,url);
    }

    @Override
    public String getFileName(File file) throws Exception {

        return fileMapper.selectNameById(file.getId());

    }

    @Override
    public void deleteFile(File file) throws Exception {
        fileUtil.delete(file.getFilePath());
        fileMapper.deleteFileById(file.getId());
    }



    @Override
    public void addExperimentScore(Exp_score exp_score) throws Exception {
        exp_scoreMapper.insert(exp_score);
    }

    @Override
    public PageModel getStuOfExperiment(PageModel pageModel,Experiment experiment) throws Exception {
        PageHelper.startPage(pageModel.getPageNum(),pageModel.getPageSize());
        List<User> userList=userMapper.selectByExpId(experiment.getId());
        PageInfo pageInfo=new PageInfo(userList);
        pageModel.setList(userList);
        pageModel.setTotal((int) pageInfo.getTotal());
        return pageModel;
    }

    @Override
    public List<Exp_commit> getWork(Experiment experiment, User user) throws Exception {
        Integer expId=experiment.getId();
        Integer userId=user.getId();
        List<Exp_commit> exp_commitList=exp_commitMapper.selectByExpIdAndUserId(expId,userId);
        return exp_commitList;
    }

    @Override
    public String getImgUrlByFile_userId(File_user file_user) throws Exception {
        Integer file_userId=file_user.getId();

        String imgUrl=file_userMapper.getUrlByFile_userId(file_userId);

        imgUrl="http://180.76.237.179/"+imgUrl;
        return imgUrl;
    }

    @Override
    public PageModel getAllCourse( PageModel pageModel) throws Exception {
        PageHelper.startPage(pageModel.getPageNum(),pageModel.getPageSize());

        List<Course> courseList=courseMapper.selectAll();
        PageInfo pageInfo=new PageInfo(courseList);
        pageModel.setTotal((int)pageInfo.getTotal());
        pageModel.setList(courseList);
        return pageModel;
    }

    @Override
    public List<Major> getAllMajors() throws Exception {
        List<Major> majorList=majorMapper.selectAll();
        return majorList;
    }

    @Override
    public void deleteCourse(List<Course> courseList) throws Exception {
        for(Course course:courseList)
        {
            courseMapper.deleteById(course.getId());
        }
    }

    @Override
    public String getFilePath(File file) throws Exception {
        return fileMapper.selectFilePathById(file.getId());
    }
}
