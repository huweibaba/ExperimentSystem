package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Auth_group;
import com.byk.experimentsystem.entity.Auth_groupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Auth_groupMapper {
    int countByExample(Auth_groupExample example);

    int deleteByExample(Auth_groupExample example);

    int insert(Auth_group record);

    int insertSelective(Auth_group record);

    List<Auth_group> selectByExample(Auth_groupExample example);

    int updateByExampleSelective(@Param("record") Auth_group record, @Param("example") Auth_groupExample example);

    int updateByExample(@Param("record") Auth_group record, @Param("example") Auth_groupExample example);
}