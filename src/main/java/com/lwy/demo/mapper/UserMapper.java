package com.lwy.demo.mapper;


import com.lwy.demo.bean.User;
import com.lwy.demo.bean.Usertime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    /**
     * 查询用户是否存活
     */
    @Select("select alive from user where username = #{username}")
    int aliveuser(String username);
    /**
     * 查询所有有的用户名
     */
    @Select("select username from user")
    List<String> selectallusername();
    /**
     * 写入用户登陆时间
     */
    @Insert("insert into usertime(username) values (#{username})")
    void addusertime(String username);
    /**
     * 查询所有用户登陆时间
     */
    @Select("select * from usertime order by id desc")
    List<Usertime> selectusertime();
    /**
     * 查询用户登录的总数
     */
    @Select("select count(*) from usertime")
    int countusertime();


}
