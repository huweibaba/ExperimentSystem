package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Option_log;
import com.byk.experimentsystem.entity.Option_logExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Option_logMapper {
    int countByExample(Option_logExample example);

    int deleteByExample(Option_logExample example);

    int insert(Option_log record);

    int insertSelective(Option_log record);

    List<Option_log> selectByExample(Option_logExample example);

    int updateByExampleSelective(@Param("record") Option_log record, @Param("example") Option_logExample example);

    int updateByExample(@Param("record") Option_log record, @Param("example") Option_logExample example);
}