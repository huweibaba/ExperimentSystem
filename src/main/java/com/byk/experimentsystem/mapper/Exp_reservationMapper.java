package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Exp_reservation;
import com.byk.experimentsystem.entity.Exp_reservationExample;
import java.util.List;

import com.byk.experimentsystem.entity.Experiment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Exp_reservationMapper {
    int countByExample(Exp_reservationExample example);

    int deleteByExample(Exp_reservationExample example);

    int insert(Exp_reservation record);

    int insertSelective(Exp_reservation record);

    List<Exp_reservation> selectByExample(Exp_reservationExample example);

    int updateByExampleSelective(@Param("record") Exp_reservation record, @Param("example") Exp_reservationExample example);

    int updateByExample(@Param("record") Exp_reservation record, @Param("example") Exp_reservationExample example);

    @Select("select * from exp_reservation where exp_id=#{experiment.id}")
    List<Exp_reservation> selectByExpId(@Param("experiment") Experiment experiment);

    @Select("select count(*) from exp_reservation where reserved_uid=#{userId}")
    Integer selectCountByUser(@Param("userId") Integer userId);

    @Select("select count(*) from exp_reservation where exp_id=#{experiment.id}")
    Integer selectCountByExperiment(@Param("experiment") Experiment experiment);




}