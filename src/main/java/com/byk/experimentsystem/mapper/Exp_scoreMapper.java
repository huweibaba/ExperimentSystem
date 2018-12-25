package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Exp_score;
import com.byk.experimentsystem.entity.Exp_scoreExample;
import java.util.List;

import com.byk.experimentsystem.entity.Experiment;
import com.byk.experimentsystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Exp_scoreMapper {
    int countByExample(Exp_scoreExample example);

    int deleteByExample(Exp_scoreExample example);

    int insert(Exp_score record);

    int insertSelective(Exp_score record);

    List<Exp_score> selectByExample(Exp_scoreExample example);

    int updateByExampleSelective(@Param("record") Exp_score record, @Param("example") Exp_scoreExample example);

    int updateByExample(@Param("record") Exp_score record, @Param("example") Exp_scoreExample example);

    @Select("select es.* from exp_score es,exp_reservation  er where er.reserved_uid=#{user.id} and es.exp_rid=er.id")
    List<Exp_score> selectByUser(@Param("user") User user);

    @Select("select es.* from exp_score es,exp_reservation er where er.exp_id=(select exp_id from exp_reservation where id=#{expRid} and es.exp_rid=er.id)")
    List<Exp_score> selectByExpRid(@Param("expRid") Integer expRid);

    @Select("select es.* from exp_reservation er,exp_score es where er.exp_id=#{expId} and es.exp_rid=er.id")
    List<Exp_score> selectByExpId(@Param("expId") Integer expId);

    @Select("select es.* from user u,exp_reservation er,exp_score es where u.class_id=#{classId} and er.reserved_uid=u.id and er.exp_id=#{expId} and es.exp_rid=er.id")
    List<Exp_score> selectByClass(@Param("classId") Integer classId,@Param("expId") Integer expId);

    @Select("select e.* from experiment e,exp_reservation er,exp_score es where es.score=#{score} and es.exp_rid=er.id and er.exp_id=e.id")
    Experiment selectExpByScore(@Param("score") Integer score);



}