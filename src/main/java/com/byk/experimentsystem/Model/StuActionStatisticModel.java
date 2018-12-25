package com.byk.experimentsystem.Model;

import com.byk.experimentsystem.entity.Experiment;

import java.util.Map;

public class StuActionStatisticModel {
    Integer reservationCount;
    Integer submitCount;
    Integer signCount;
    Integer maxScore;
    Integer minScore;
    Integer averageScore;
    Map<String,Integer>  scoreCount;
    Experiment maxScoreAt;
    Experiment minScoreAt;

    public Integer getReservationCount() {
        return reservationCount;
    }

    public void setReservationCount(Integer reservationCount) {
        this.reservationCount = reservationCount;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public Map<String, Integer> getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(Map<String, Integer> scoreCount) {
        this.scoreCount = scoreCount;
    }

    public Experiment getMaxScoreAt() {
        return maxScoreAt;
    }

    public void setMaxScoreAt(Experiment maxScoreAt) {
        this.maxScoreAt = maxScoreAt;
    }

    public Experiment getMinScoreAt() {
        return minScoreAt;
    }

    public void setMinScoreAt(Experiment minScoreAt) {
        this.minScoreAt = minScoreAt;
    }
}
