package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.Exp_commit;
import com.byk.experimentsystem.entity.File_user;
import com.byk.experimentsystem.entity.File_userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface File_userMapper {
    int countByExample(File_userExample example);

    int deleteByExample(File_userExample example);

    int insert(File_user record);

    int insertSelective(File_user record);

    List<File_user> selectByExample(File_userExample example);

    int updateByExampleSelective(@Param("record") File_user record, @Param("example") File_userExample example);

    int updateByExample(@Param("record") File_user record, @Param("example") File_userExample example);

    void insertRelations(List<File_user> file_userList) throws Exception;

    @Select("select * from file_user where id=#{exp_commit.answerImgId}")
    File_user selectByFid(@Param("exp_commit") Exp_commit exp_commit);

    @Select("select f.file_path from file_user fu,file f where fu.id=#{file_userId} and f.id=fu.file_id")
    String getUrlByFile_userId(@Param("file_userId") Integer file_userId) throws  Exception;
}