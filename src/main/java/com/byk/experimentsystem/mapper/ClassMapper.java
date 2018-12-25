package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Class;
import com.byk.experimentsystem.entity.ClassExample;
import java.util.List;

import com.byk.experimentsystem.entity.Major;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper {
    int countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    @Select("select id from class where name=#{name} and grade=#{grade} and major_id=#{majorId}")
    Integer getIdByNGM(@Param("name")String name,@Param("grade") Integer grade,@Param("majorId") Integer majorId);

    @Select("select * from class where major_id=#{majorId}")
    List<Class> selectByMajorId(@Param("majorId") Integer majorId);
}