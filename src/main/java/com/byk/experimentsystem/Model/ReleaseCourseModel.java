package com.byk.experimentsystem.Model;

import com.byk.experimentsystem.entity.Course;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ReleaseCourseModel {

    private String courseName;

    private Integer classHour;
    private Integer credit;
    String universityName;
    String campusName;
    String collegeName;
    String majorName;

    public Course getCourse()
    {
        Course course =new Course();
        course.setClassHour(classHour);
        course.setName(courseName);
        course.setCredit(credit);
        return course;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCollegeName() {

        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCampusName() {

        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getUniversityName() {

        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }




    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }
}
