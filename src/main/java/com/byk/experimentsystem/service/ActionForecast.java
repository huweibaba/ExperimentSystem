package com.byk.experimentsystem.service;

import com.byk.experimentsystem.Model.TestQuestions;
import com.byk.experimentsystem.entity.User;

import java.util.Map;

public interface ActionForecast {
    public Map scoreForecast(User user) throws Exception;
    public TestQuestions forecastQuestions() throws Exception;

}
