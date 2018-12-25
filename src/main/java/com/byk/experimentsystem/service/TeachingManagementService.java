package com.byk.experimentsystem.service;

import com.byk.experimentsystem.Model.*;
import com.byk.experimentsystem.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.lang.Class;
import java.util.Date;
import java.util.List;


public interface TeachingManagementService {
    //发布课程
    public void releaseCourse(Course course) throws Exception;
    //得到某个专业的所有课程
    public List<Course> getCourses(Major major) throws Exception;
    //发布实验
    public void releaseExperiment(Experiment experiment) throws Exception;
    //发布实验时间
    public void releaseExperimentTime(Experiment experiment) throws Exception;
    //得到目前登录教师已录入但是未发布时间的实验
    public PageModel getNoReleaseExperiments(PageModel pageModel,Teacher CurrentTeacher) throws Exception;
    //得到目前登录教师已经发布时间的实验
    public PageModel getReleasedExperiments(PageModel pageModel,Teacher currentTeacher) throws Exception;
    //发布实验资料
    public void releaseData(MultipartFile[] multipartFiles,Experiment experiment,Teacher teacher) throws Exception;
   //下载文件
    public void download(OutputStream outputStream,File file) throws Exception;
    //通过文件的url得到文件名
    public String getFileName(File file) throws Exception;
    //
    public void deleteFile(File file) throws Exception;



    public void addExperimentScore(Exp_score exp_score) throws Exception;

    public PageModel getStuOfExperiment(PageModel pageModel,Experiment experiment) throws  Exception;

    public List<Exp_commit> getWork(Experiment experiment,User user) throws Exception;

    public String getImgUrlByFile_userId(File_user file_user) throws Exception;

    public PageModel getAllCourse(PageModel pageMoel) throws  Exception;

    public List<Major> getAllMajors() throws  Exception;

    public void deleteCourse(List<Course> courseList) throws  Exception;

    public String getFilePath(File file) throws  Exception;



}
