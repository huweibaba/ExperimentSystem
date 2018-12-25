package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Classroom;
import com.byk.experimentsystem.entity.ClassroomExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomMapper {
    int countByExample(ClassroomExample example);

    int deleteByExample(ClassroomExample example);
    @Options(useGeneratedKeys = true, keyProperty = "studId")

    int insert(Classroom record);

    int insertSelective(Classroom record);

    List<Classroom> selectByExample(ClassroomExample example);

    int updateByExampleSelective(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByExample(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    @Select("select id from classroom where floor=#{floor} and num=#{num} and building_id=#{buildingId}")
    Integer getIdByFNB(@Param("floor") Integer floor,@Param("num") Integer num,@Param("buildingId") Integer buildingId);

    @Update("update classroom set status=#{classroom.status} where id=#{classroom.id}")
    void updateStatus(@Param("classroom") Classroom classroom);

    @Select("select * from classroom where building_id=#{buildingId}")
    List<Classroom> selectByBuildingId(@Param("buildingId") Integer buildingId);

    @Select("select * from classroom where id=#{id}")
   Classroom selectById(@Param("id") Integer id);

}