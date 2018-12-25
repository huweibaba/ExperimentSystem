package com.byk.experimentsystem.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JSONUtil {
    public static ObjectMapper objectMapper=new ObjectMapper();
    public static <T> T parseMap(Map<String,Object> map, Class<T> tClass) throws Exception {
        String json=objectMapper.writeValueAsString(map);
        T t=objectMapper.readValue(json,tClass);
        return t;
    }

}
