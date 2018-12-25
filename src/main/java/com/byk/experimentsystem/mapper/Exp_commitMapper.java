package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Exp_commit;
import com.byk.experimentsystem.entity.Exp_commitExample;
import java.util.List;

import com.byk.experimentsystem.entity.Exp_reservation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Exp_commitMapper {
    int countByExample(Exp_commitExample example);

    int deleteByExample(Exp_commitExample example);

    int insert(Exp_commit record);

    int insertSelective(Exp_commit record);

    List<Exp_commit> selectByExample(Exp_commitExample example);

    int updateByExampleSelective(@Param("record") Exp_commit record, @Param("example") Exp_commitExample example);

    int updateByExample(@Param("record") Exp_commit record, @Param("example") Exp_commitExample example);

    @Select("select * from exp_commit where exp_rid=#{exp_rid}")
    List<Exp_commit> selectByExpRid(@Param("exp_rid") Integer exp_rid);

    @Select("select count(DISTINCT exp_rid) from exp_commit ec,exp_reservation er where er.reserved_uid=#{userId} and ec.exp_rid=er.id")
    Integer selectExpCount(@Param("userId") Integer userId);

    @Select("select ec.* from exp_commit ec,exp_reservation er where exp_rid=er.id and er.exp_id=#{expId} and er.reserved_uid=#{userId}")
    List<Exp_commit> selectByExpIdAndUserId(@Param("expId") Integer expId,@Param("userId") Integer userId);
}