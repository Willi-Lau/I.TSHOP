package com.lwy.demo.mapper;


import com.lwy.demo.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 对数据库执行增加操作，增加注册信息到数据库
     * @param user
     */
     void adduser(User user);

    /**
     * 验证登录信息
     */
     @Select("select password from user where username = #{username}")
     String checkupdate(String username);



}
