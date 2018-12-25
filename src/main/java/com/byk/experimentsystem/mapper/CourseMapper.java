package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Course;
import com.byk.experimentsystem.entity.CourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(Course record) throws  Exception;

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    @Select("select id from course where name=#{name}")
    Integer getCourseIdByName(String name);

    @Select("select id from course where name=#{name} and major_id=#{majorId}")
    Integer getIdByNM(@Param("name")String name,@Param("majorId") Integer majorId);

    @Select("select * from course where major_id=#{majorId}")
    List<Course> selectByMajorId(@Param("majorId") Integer majorId);

    @Select("select * from course")
    List<Course> selectAll() throws  Exception;
    @Delete("delete from course where id=#{id}")
    public void deleteById(@Param("id") Integer id) throws  Exception;
}