package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Equipment_repair;
import com.byk.experimentsystem.entity.Equipment_repairExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Equipment_repairMapper {
    int countByExample(Equipment_repairExample example);

    int deleteByExample(Equipment_repairExample example);

    int insert(Equipment_repair record);

    int insertSelective(Equipment_repair record);

    List<Equipment_repair> selectByExample(Equipment_repairExample example);

    int updateByExampleSelective(@Param("record") Equipment_repair record, @Param("example") Equipment_repairExample example);

    int updateByExample(@Param("record") Equipment_repair record, @Param("example") Equipment_repairExample example);
}