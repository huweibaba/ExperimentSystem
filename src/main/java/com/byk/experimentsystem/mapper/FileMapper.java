package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.File;
import com.byk.experimentsystem.entity.FileExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper {
    int countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    void insertFiles(List<File> fileList) throws Exception;

    @Select("select file_name from file where file_path=#{filePath}")
    String selectNameByUrl(@Param("filePath") String filePath) throws  Exception;

    @Delete("delete from file where id=#{fileId}")
    void deleteFileById(Integer fileId);

    @Select("select * from file where id=#{id}")
    File selectById(@Param("id") Integer id);

    @Select("select file_path from file where id=#{id}")
    String selectFilePathById(@Param("id") Integer id);

    @Select("select name from file where id=#{id}")
    String selectNameById(@Param("id") Integer id);

}