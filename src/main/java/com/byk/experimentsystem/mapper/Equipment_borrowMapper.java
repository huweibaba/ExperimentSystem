package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Equipment_borrow;
import com.byk.experimentsystem.entity.Equipment_borrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Equipment_borrowMapper {
    int countByExample(Equipment_borrowExample example);

    int deleteByExample(Equipment_borrowExample example);

    int insert(Equipment_borrow record);

    int insertSelective(Equipment_borrow record);

    List<Equipment_borrow> selectByExample(Equipment_borrowExample example);

    int updateByExampleSelective(@Param("record") Equipment_borrow record, @Param("example") Equipment_borrowExample example);

    int updateByExample(@Param("record") Equipment_borrow record, @Param("example") Equipment_borrowExample example);
}