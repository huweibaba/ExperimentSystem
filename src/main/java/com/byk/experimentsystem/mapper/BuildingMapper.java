package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Building;
import com.byk.experimentsystem.entity.BuildingExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingMapper {
    int countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);
    @Options(useGeneratedKeys = true, keyProperty = "studId")
    int insert(Building record);

    int insertSelective(Building record);

    List<Building> selectByExample(BuildingExample example);

    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);
    @Select("select id from building where name=#{name} and campus_id=#{campusId}")
    Integer getIdByNC(@Param("name") String name,@Param("campusId") Integer campusId);

    @Select("select * from building where campus_id=#{campusId}")
    List<Building> selectByCampusId(@Param("campusId") Integer campusId);
}