package com.byk.experimentsystem.Exception;

public class MyException extends Exception{
    public String exceptionMessage;
    public MyException(String exceptionMessage)
    {
        this.exceptionMessage=exceptionMessage;
    }

    public MyException()
    {

    }
    public String getMessage()
    {
        return this.exceptionMessage;
    }


}
