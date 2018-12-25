package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Major;
import com.byk.experimentsystem.entity.MajorExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorMapper {
    int countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    @Options(useGeneratedKeys = true, keyProperty = "studId")
    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);


    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    @Select("select id from major where name=#{name} and college_id=#{collegeId}")
     Integer getIdByNC(@Param("name") String name,@Param("collegeId") Integer collegeId);
    @Select("select * from major where college_id=#{collegeId}")
    List<Major> selectByCollegeId(@Param("collegeId") Integer collegeId);

    @Select("select * from major")
    List<Major> selectAll() throws  Exception;
 }