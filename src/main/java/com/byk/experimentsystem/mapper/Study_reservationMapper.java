package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Study_reservation;
import com.byk.experimentsystem.entity.Study_reservationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Study_reservationMapper {
    int countByExample(Study_reservationExample example);

    int deleteByExample(Study_reservationExample example);

    int insert(Study_reservation record);

    int insertSelective(Study_reservation record);

    List<Study_reservation> selectByExample(Study_reservationExample example);

    int updateByExampleSelective(@Param("record") Study_reservation record, @Param("example") Study_reservationExample example);

    int updateByExample(@Param("record") Study_reservation record, @Param("example") Study_reservationExample example);
}