package com.lwy.demo.service;

import com.lwy.demo.bean.User;
import com.lwy.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void adduserinformation(User user){
         userMapper.adduser(user);
    }


    public String checkupdate(String name){
        String checkupdate = userMapper.checkupdate(name);
        //饭hi查询到的密码
        return checkupdate;
    }

    public int aliveuser(String username){
        return userMapper.aliveuser(username);
    }

}
