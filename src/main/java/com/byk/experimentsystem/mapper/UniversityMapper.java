package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.University;
import com.byk.experimentsystem.entity.UniversityExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityMapper {
    int countByExample(UniversityExample example);

    int deleteByExample(UniversityExample example);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(University record);

    int insertSelective(University record);

    List<University> selectByExample(UniversityExample example);

    int updateByExampleSelective(@Param("record") University record, @Param("example") UniversityExample example);

    int updateByExample(@Param("record") University record, @Param("example") UniversityExample example);

    @Select("select id from university where name=#{name}")
    Integer getIdByName(String name);

    @Select("select * from university")
    List<University> selectAllUniversity();
}