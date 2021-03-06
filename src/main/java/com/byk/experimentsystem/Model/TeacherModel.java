package com.byk.experimentsystem.Model;

import com.byk.experimentsystem.entity.Teacher;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TeacherModel {

    private Integer id;
    @NotNull(message = "教工号不能为空")
    private Integer teaId;
    @NotNull(message ="教师名字不能为空")
    private String teaName;
    @NotNull(message = "用户昵称不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "性别不能为空")
    private Integer sex;

    private Integer age;

    private String birth;

    private String email;

    private String address;

    private String phone;

    private String avatarUrl;

    private Integer isTeacherConfirm;

    private Date createdat;

    private Date updatedat;

    private Integer collegeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
        this.birth = birth == null ? null : birth.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Integer getIsTeacherConfirm() {
        return isTeacherConfirm;
    }

    public void setIsTeacherConfirm(Integer isTeacherConfirm) {
        this.isTeacherConfirm = isTeacherConfirm;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Teacher getTeacher()
    {
        Teacher teacher=new Teacher();
        teacher.setUserName(userName);
        teacher.setPassword(password);
        teacher.setEmail(email);
        teacher.setCollegeId(collegeId);
        teacher.setSex(sex);
        teacher.setTeaName(teaName);
        teacher.setTeaId(teaId);
        teacher.setAddress(address);
        teacher.setAge(age);
        teacher.setAvatarUrl(avatarUrl);
        teacher.setBirth(birth);
        teacher.setPhone(phone);
        return teacher;
    }
}
