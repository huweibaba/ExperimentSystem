package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Auth_group_permissions;
import com.byk.experimentsystem.entity.Auth_group_permissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Auth_group_permissionsMapper {
    int countByExample(Auth_group_permissionsExample example);

    int deleteByExample(Auth_group_permissionsExample example);

    int insert(Auth_group_permissions record);

    int insertSelective(Auth_group_permissions record);

    List<Auth_group_permissions> selectByExample(Auth_group_permissionsExample example);

    int updateByExampleSelective(@Param("record") Auth_group_permissions record, @Param("example") Auth_group_permissionsExample example);

    int updateByExample(@Param("record") Auth_group_permissions record, @Param("example") Auth_group_permissionsExample example);
}