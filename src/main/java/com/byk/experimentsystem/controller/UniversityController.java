package com.byk.experimentsystem.controller;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.Model.ResponseModel;
import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.entity.Class;
import com.byk.experimentsystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @CrossOrigin
    @RequestMapping("/getUniversitys")
    @ResponseBody
    public ResponseModel getUniversitys()
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<University> universityList=universityService.getUniversitys();
            responseModel.setData(universityList);
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
    @RequestMapping("/getCampuses")
    @ResponseBody
    public ResponseModel getCampuses(@RequestBody University university)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<Campus> campusList=universityService.getCampuses(university);
            responseModel.setData(campusList);
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
    @RequestMapping("/getColleges")
    @ResponseBody
    public ResponseModel getColleges(@RequestBody Campus campus)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<College> collegeList=universityService.getColleges(campus);
            responseModel.setData(collegeList);
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
    @RequestMapping("/getMajors")
    @ResponseBody
    public ResponseModel getMajors(@RequestBody College college)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<Major> majorList=universityService.getMajors(college);
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
    @RequestMapping("/getBuildings")
    @ResponseBody
    public ResponseModel getBuildings(@RequestBody Campus campus)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<Building> buildingList=universityService.getBuildings(campus);
            responseModel.setData(buildingList);
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
    @RequestMapping("/getClassroom")
    @ResponseBody
    public ResponseModel getClassroom(@RequestBody Building building)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<Classroom> classroomList=universityService.getClassroom(building);
            responseModel.setData(classroomList);
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
    @RequestMapping("/getClasses")
    @ResponseBody
    public ResponseModel getClasses(@RequestBody Major major)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(1);

        try {
            List<Class> classList=universityService.getClasses(major);
            responseModel.setData(classList);
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
