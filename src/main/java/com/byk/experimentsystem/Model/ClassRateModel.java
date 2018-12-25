package com.byk.experimentsystem.Model;

public class ClassRateModel {
    Integer needStuNumber;
    Integer realStuNumber;
    float classRate;

    public Integer getRealStuNumber() {
        return realStuNumber;
    }

    public void setRealStuNumber(Integer realStuNumber) {
        this.realStuNumber = realStuNumber;
    }

    public float getClassRate() {
        return classRate;
    }

    public void setClassRate(float classRate) {
        this.classRate = classRate;
    }

    public Integer getNeedStuNumber() {
        return needStuNumber;
    }

    public void setNeedStuNumber(Integer needStuNumber) {
        this.needStuNumber = needStuNumber;
    }
}
