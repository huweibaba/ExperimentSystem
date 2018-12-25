package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Campus;
import com.byk.experimentsystem.entity.CampusExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusMapper {
    int countByExample(CampusExample example);

    int deleteByExample(CampusExample example);
    @Options(useGeneratedKeys = true, keyProperty = "studId")

    int insert(Campus record);

    int insertSelective(Campus record);

    List<Campus> selectByExample(CampusExample example);

    int updateByExampleSelective(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByExample(@Param("record") Campus record, @Param("example") CampusExample example);

    @Select("select id from campus where name=#{name} and university_id=#{universityId}")
    Integer getIdByNU(@Param("name") String name,@Param("universityId") Integer universityId);

    @Select("select * from campus where university_id=#{universityId}")
    List<Campus> selectByUniversityId(@Param("universityId") Integer universityId);
}