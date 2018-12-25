package com.byk.experimentsystem.Model;

import java.util.List;
import java.util.Map;

public class ScoreStatisticModel
{Integer averageScore;
 Map<String,Integer> map;

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Integer getAverageScore() {

        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }
}
