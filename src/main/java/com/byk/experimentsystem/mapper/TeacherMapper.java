package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Teacher;
import com.byk.experimentsystem.entity.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    @Select("select * from teacher where user_name=#{userName}")
    Teacher SelectTeacherByUserName(@Param("userName") String userName);

    @Select("select * from teacher where tea_id=#{teaId} and password=#{password}")
    Teacher queryUser(@Param("teaId")Integer teaId,@Param("password") String password);

    @Select("select * from teacher where tea_id=#{teaId}")
    Teacher queryTeacherByTeaId(@Param("teaId") Integer teaId);

    @Select("select * from teacher where id=#{id}")
    Teacher selectById(@Param("id") Integer id);

    @Select("select * from teacher where tea_id=#{teaId}")
    Teacher selectByTeaId(@Param("teaId") Integer teaId);



    void updateOne(Teacher teacher) throws Exception;


}