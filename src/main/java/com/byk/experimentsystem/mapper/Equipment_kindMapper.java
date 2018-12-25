package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Equipment_kind;
import com.byk.experimentsystem.entity.Equipment_kindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Equipment_kindMapper {
    int countByExample(Equipment_kindExample example);

    int deleteByExample(Equipment_kindExample example);

    int insert(Equipment_kind record);

    int insertSelective(Equipment_kind record);

    List<Equipment_kind> selectByExample(Equipment_kindExample example);

    int updateByExampleSelective(@Param("record") Equipment_kind record, @Param("example") Equipment_kindExample example);

    int updateByExample(@Param("record") Equipment_kind record, @Param("example") Equipment_kindExample example);
}