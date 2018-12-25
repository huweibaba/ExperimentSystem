package com.byk.experimentsystem.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class JSRUtil {
    public static List<String> getAllMessage(BindingResult bindingResult)
    {
        List<ObjectError> objectErrorList=bindingResult.getAllErrors();
        List<String> errorList=new ArrayList<String>();
        for(ObjectError objectError:objectErrorList)
        {
            errorList.add(objectError.getDefaultMessage());
        }
        return errorList;
    }

}
