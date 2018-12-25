package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.PageModel;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.service.TeachingManagementService;
import com.byk.experimentsystem.util.JSONUtil;
import com.byk.experimentsystem.util.JSRUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teachingManage")
public class TeachingManageController {
    @Autowired
    TeachingManagementService teachingManagementService;

    @CrossOrigin
    @RequestMapping("/getAllCourse")
    @ResponseBody
    public ResponseModel getAllCourse(@RequestBody PageModel pageModel)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
          pageModel=teachingManagementService.getAllCourse(pageModel);
            responseModel.setData(pageModel);
        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
         e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/releaseCourse")
    @ResponseBody
    public ResponseModel releaseCourse(@Valid @RequestBody Course course, BindingResult bindingResult)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        if (bindingResult.hasErrors()) {
            responseModel.setParameterError(JSRUtil.getAllMessage(bindingResult));
            responseModel.setStatus(0);
            return responseModel;
        }


        try {
           teachingManagementService.releaseCourse(course);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }

    @CrossOrigin
    @RequestMapping("/getAllMajor")
    @ResponseBody
    public ResponseModel getAllMajor()
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            List<Major> majorList=teachingManagementService.getAllMajors();
            responseModel.setData(majorList);
        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }

    @CrossOrigin
    @RequestMapping("/deleteCourse")
    @ResponseBody
    public ResponseModel deleteCourse(@RequestBody List<Course> courseList)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            teachingManagementService.deleteCourse(courseList);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }



    @CrossOrigin
    @RequestMapping("/releaseExperiment")
    @ResponseBody
    public ResponseModel releaseExperiment(@Valid @RequestBody Experiment experiment, BindingResult bindingResult, HttpSession httpSession)
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        if (bindingResult.hasErrors()) {
            responseModel.setParameterError(JSRUtil.getAllMessage(bindingResult));
            responseModel.setStatus(0);
            return responseModel;
        }


        try {
            Teacher teacher=(Teacher)httpSession.getAttribute("teacher");
            experiment.setReleaseUid(teacher.getId());
            teachingManagementService.releaseExperiment(experiment);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/releaseExperimentTime")
    @ResponseBody
    public ResponseModel releaseExperimentTime(@Valid @RequestBody Experiment experiment, BindingResult bindingResult, HttpSession httpSession)
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        if (bindingResult.hasErrors()) {
            responseModel.setParameterError(JSRUtil.getAllMessage(bindingResult));
            responseModel.setStatus(0);
            return responseModel;
        }


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(experiment.getDate()));
            teachingManagementService.releaseExperimentTime(experiment);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }

    @CrossOrigin
    @RequestMapping("/getNoReleaseExperiments")
    @ResponseBody
    public ResponseModel getNoReleaseExperiments(@RequestBody PageModel pageModel,HttpSession httpSession)
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            Teacher currentTeacher=(Teacher) httpSession.getAttribute("teacher");
            teachingManagementService.getNoReleaseExperiments(pageModel,currentTeacher);
            responseModel.setData(pageModel);
        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }

    @CrossOrigin
    @RequestMapping("/getReleasedExperiments")
    @ResponseBody
    public ResponseModel getReleasedExperiments(@RequestBody PageModel pageModel,HttpSession httpSession)
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            Teacher currentTeacher=(Teacher) httpSession.getAttribute("teacher");
            teachingManagementService.getReleasedExperiments(pageModel,currentTeacher);
            responseModel.setData(pageModel);
        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }

    @CrossOrigin
    @RequestMapping("/releaseData")
    @ResponseBody
    public ResponseModel releaseData(@RequestParam("file") MultipartFile[] multipartFiles, Integer expId, HttpSession httpSession)
    {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            Teacher currentTeacher=(Teacher) httpSession.getAttribute("teacher");
            Experiment experiment=new Experiment();
            experiment.setId(expId);
            teachingManagementService.releaseData(multipartFiles,experiment,currentTeacher);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/download")
    @ResponseBody
    public void download(@RequestBody File file, HttpServletResponse httpServletResponse)
    {
        try {
            OutputStream outputStream=httpServletResponse.getOutputStream();
            String fileName=teachingManagementService.getFileName(file);
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("gb2312"),"ISO-8859-1") + "\"");
            teachingManagementService.download(outputStream,file);
        }
        catch (Exception e)
        {
        }
    }


    @CrossOrigin
    @RequestMapping("/deleteFile")
    @ResponseBody
    public ResponseModel deleteFile(@RequestBody File file)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            String filePath=teachingManagementService.getFilePath(file);
            file.setFilePath(filePath);
            teachingManagementService.deleteFile(file);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/addExperimentScore")
    @ResponseBody
    public ResponseModel addExperimentScore(@RequestBody Exp_score exp_score,HttpSession httpSession)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            Teacher teacher=(Teacher) httpSession.getAttribute("teacher");
            exp_score.setCommentUid(teacher.getId());
           teachingManagementService.addExperimentScore(exp_score);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/getStuOfExperiment")
    @ResponseBody
    public ResponseModel getStuOfExperiment(@RequestBody Map<String,Object> map)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            PageModel pageModel= JSONUtil.parseMap((Map<String, Object>) map.get("pageModel"),PageModel.class);
            Experiment experiment=JSONUtil.parseMap((Map<String, Object>) map.get("experiment"),Experiment.class);
            pageModel=teachingManagementService.getStuOfExperiment(pageModel,experiment);
            responseModel.setData(pageModel);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/getWork")
    @ResponseBody
    public ResponseModel getWork(@RequestBody Map<String,Object> map)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
            User user= JSONUtil.parseMap((Map<String, Object>) map.get("user"),User.class);
            Experiment experiment=JSONUtil.parseMap((Map<String, Object>) map.get("experiment"),Experiment.class);
            List<Exp_commit> exp_commitList=teachingManagementService.getWork(experiment,user);
            responseModel.setData(exp_commitList);

        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }


    @CrossOrigin
    @RequestMapping("/getImgUrl")
    @ResponseBody
    public ResponseModel getImgUrl(@RequestBody File_user file_user)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);
        try {
               String imgUrl=teachingManagementService.getImgUrlByFile_userId(file_user);
               responseModel.setData(imgUrl);
        } catch (Exception e) {
            responseModel.setStatus(0);
            if (e instanceof MyException)
                responseModel.setMessage(e.getMessage());
            else
                responseModel.setMessage("后台未知异常");
            e.printStackTrace();
        }
        return responseModel;
    }






}
