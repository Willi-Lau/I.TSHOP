package com.lwy.demo.service;

import com.lwy.demo.bean.User;
import com.lwy.demo.bean.Usertime;

import java.util.List;

public interface UserService {

    void adduserinformation(User user);

    String checkupdate(String name);

    int aliveuser(String username);

    List<String> selectallusername();

    void addusertime(String username);

    List<Usertime> selectusertime();

    int countusertime();

}
