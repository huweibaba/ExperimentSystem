package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.Model.ReleaseExperimentTimeModel;
import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.ExperimentExample;
import java.util.List;

import com.byk.experimentsystem.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentMapper {
    int countByExample(ExperimentExample example);

    int deleteByExample(ExperimentExample example);

    int insert(Experiment record);

    int insertSelective(Experiment record);

    List<Experiment> selectByExample(ExperimentExample example);

    int updateByExampleSelective(@Param("record") Experiment record, @Param("example") ExperimentExample example);

    int updateByExample(@Param("record") Experiment record, @Param("example") ExperimentExample example);


    @Update("update experiment set date=#{experiment.date},time_slot=#{experiment.timeSlot} where id=#{experiment.id}")
    int updateTime(@Param("experiment") Experiment experiment) throws Exception;

    @Select("select * from experiment where (date is null) and (time_slot is null) and release_uid=#{releaseUid}")
    List<Experiment> selectNoReleaseExperimentsByTid(@Param("releaseUid") Integer releaseUid);

    @Select("select * from experiment where (date is not null) and (time_slot is not null) and release_uid=#{releaseUid}")
    List<Experiment> selectReleasedtExperimentsByTid(@Param("releaseUid")Integer releaseUid);

    void updateOne(Experiment experiment) throws Exception;

    @Select("select * from experiment where id=#{id}")
    Experiment selectById(@Param("id") Integer id);


    @Select("select * from experiment")
    List<Experiment> selectAll();





}