package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Auth_user;
import com.byk.experimentsystem.entity.Auth_userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Auth_userMapper {
    int countByExample(Auth_userExample example);

    int deleteByExample(Auth_userExample example);

    int insert(Auth_user record);

    int insertSelective(Auth_user record);

    List<Auth_user> selectByExample(Auth_userExample example);

    int updateByExampleSelective(@Param("record") Auth_user record, @Param("example") Auth_userExample example);

    int updateByExample(@Param("record") Auth_user record, @Param("example") Auth_userExample example);
}