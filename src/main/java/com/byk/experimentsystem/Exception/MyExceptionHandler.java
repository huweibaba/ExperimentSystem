package com.byk.experimentsystem.Exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyExceptionHandler {
    Exception e;

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }
    public String getMessage()
    {
        return e.getMessage();
    }
}
