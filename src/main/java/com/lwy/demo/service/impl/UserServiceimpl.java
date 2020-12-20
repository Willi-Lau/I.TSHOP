package com.lwy.demo.service.impl;

import com.lwy.demo.bean.User;
import com.lwy.demo.bean.Usertime;
import com.lwy.demo.mapper.UserMapper;
import com.lwy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceimpl implements UserService {
    
    
    
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

    @Override
    public List<String> selectallusername() {
        return userMapper.selectallusername();
    }

    @Override
    public void addusertime(String username) {
        userMapper.addusertime(username);
    }

    @Override
    public List<Usertime> selectusertime() {
        return userMapper.selectusertime();
    }

    @Override
    public int countusertime() {
        return userMapper.countusertime();
    }

}
