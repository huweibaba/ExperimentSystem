package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Equipment;
import com.byk.experimentsystem.entity.EquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMapper {
    int countByExample(EquipmentExample example);

    int deleteByExample(EquipmentExample example);

    int insert(Equipment record) throws Exception;

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentExample example);
}