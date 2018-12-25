package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Exp_data;
import com.byk.experimentsystem.entity.Exp_dataExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Exp_dataMapper {
    int countByExample(Exp_dataExample example);

    int deleteByExample(Exp_dataExample example);

    int insert(Exp_data record);

    int insertSelective(Exp_data record);

    List<Exp_data> selectByExample(Exp_dataExample example);

    int updateByExampleSelective(@Param("record") Exp_data record, @Param("example") Exp_dataExample example);

    int updateByExample(@Param("record") Exp_data record, @Param("example") Exp_dataExample example);

    void insertRelations(Map map) throws Exception;
}