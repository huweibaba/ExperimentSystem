package com.byk.experimentsystem.Model;

import com.byk.experimentsystem.entity.Teacher;
import org.springframework.validation.annotation.Validated;

@Validated
public class RegisterModel {


    private Integer teaId;

    private String teaName;
    private String userName;


    private String password;




    private Integer sex;

    private Integer age;

    private String birth;

    private String email;

    private String address;

    private String phone;

    private String avatarUrl;

    private Integer isTeacherComfirm;




    String universityName;
    String campusName;
    String collegeName;


    public Teacher getTeacher()
    {
        Teacher teacher=new Teacher();

        teacher.setUserName(userName);
        teacher.setPassword(password);
        teacher.setAddress(address);
        teacher.setAge(age);
        teacher.setAvatarUrl(avatarUrl);
        teacher.setBirth(birth);
        teacher.setEmail(email);
        teacher.setPhone(phone);
        teacher.setSex(sex);
        teacher.setTeaName(teaName);
        teacher.setTeaId(teaId);
        return teacher;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getIsTeacherComfirm() {
        return isTeacherComfirm;
    }

    public void setIsTeacherComfirm(Integer isTeacherComfirm) {
        this.isTeacherComfirm = isTeacherComfirm;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }


}
