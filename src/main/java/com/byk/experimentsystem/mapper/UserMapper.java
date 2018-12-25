package com.byk.experimentsystem.mapper;

import com.byk.experimentsystem.entity.User;
import com.byk.experimentsystem.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @Select("select * from user where user_name=#{userName} and password=#{password}")
    User queryUser(@Param("userName") String userName,@Param("password") String password) throws Exception;//根据账号和密码信息判断用户是否存在，若存在则返回用户的对象，否则返回空

    @Select("select * from user where stu_id=#{stuId}")

    User queryUserBystuId(@Param("stuId") Integer stuId);

    @Select("select * from user where user_name=#{userName}")
    User queryUserByUserName(@Param("userName") String userName);

    @Select("select * from user where id=#{id}")
    User queryUserById(@Param("id") Integer id);

    @Select("select u.* from exp_reservation er,user u where er.exp_id=#{expId} and u.id=er.reserved_uid")
    List<User> selectByExpId(@Param("expId") Integer expId);
}