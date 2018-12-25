package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Auth_user_user_permissions;
import com.byk.experimentsystem.entity.Auth_user_user_permissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Auth_user_user_permissionsMapper {
    int countByExample(Auth_user_user_permissionsExample example);

    int deleteByExample(Auth_user_user_permissionsExample example);

    int insert(Auth_user_user_permissions record);

    int insertSelective(Auth_user_user_permissions record);

    List<Auth_user_user_permissions> selectByExample(Auth_user_user_permissionsExample example);

    int updateByExampleSelective(@Param("record") Auth_user_user_permissions record, @Param("example") Auth_user_user_permissionsExample example);

    int updateByExample(@Param("record") Auth_user_user_permissions record, @Param("example") Auth_user_user_permissionsExample example);
}