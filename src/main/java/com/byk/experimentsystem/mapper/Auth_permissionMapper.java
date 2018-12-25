package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Auth_permission;
import com.byk.experimentsystem.entity.Auth_permissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Auth_permissionMapper {
    int countByExample(Auth_permissionExample example);

    int deleteByExample(Auth_permissionExample example);

    int insert(Auth_permission record);

    int insertSelective(Auth_permission record);

    List<Auth_permission> selectByExample(Auth_permissionExample example);

    int updateByExampleSelective(@Param("record") Auth_permission record, @Param("example") Auth_permissionExample example);

    int updateByExample(@Param("record") Auth_permission record, @Param("example") Auth_permissionExample example);
}