package com.byk.experimentsystem.Model;

import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class ResponseModel {
    int status;
    List parameterError;
    String message;
    Object data;

    public List getParameterError() {
        return parameterError;
    }

    public void setParameterError(List parameterError) {
        this.parameterError = parameterError;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ResponseModel()
    {

    }

    public ResponseModel(int status, String message, Object data)
    {this.status=status;
        this.message=message;

    }




}
