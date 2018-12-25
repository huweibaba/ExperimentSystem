package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Campus;
import com.byk.experimentsystem.entity.College;
import com.byk.experimentsystem.entity.CollegeExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);
    @Options(useGeneratedKeys = true, keyProperty = "studId")
    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    @Select("select id from college where name=#{name} and campus_id=#{campusId}")
    Integer getIdByNC(@Param("name") String name,@Param("campusId") int campusId) throws Exception;

    @Select("select * from college where campus_id=#{campusId}")
    List<College> selectByCampusId(@Param("campusId") Integer campusId) throws Exception;
}