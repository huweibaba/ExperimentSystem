package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Auth_user_groups;
import com.byk.experimentsystem.entity.Auth_user_groupsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Auth_user_groupsMapper {
    int countByExample(Auth_user_groupsExample example);

    int deleteByExample(Auth_user_groupsExample example);

    int insert(Auth_user_groups record);

    int insertSelective(Auth_user_groups record);

    List<Auth_user_groups> selectByExample(Auth_user_groupsExample example);

    int updateByExampleSelective(@Param("record") Auth_user_groups record, @Param("example") Auth_user_groupsExample example);

    int updateByExample(@Param("record") Auth_user_groups record, @Param("example") Auth_user_groupsExample example);
}