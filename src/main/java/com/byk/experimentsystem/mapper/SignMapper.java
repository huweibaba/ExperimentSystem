package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.Sign;
import com.byk.experimentsystem.entity.SignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SignMapper {
    int countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignExample example);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    @Select("select count(*) from sign where sign_uid=#{userId}")
    Integer selectCountByUser(@Param("userId") Integer userId);

    @Select("select count(*) from sign,exp_reservation er where er.exp_id=#{experiment.id} and sign.exp_rid=er.id")
    Integer selectCountByExperiment(@Param("experiment") Experiment experiment);


}