package com.lwy.demo.service;

import com.lwy.demo.bean.User;

public interface UserService {

    public void adduserinformation(User user);

    public String checkupdate(String name);

    public int aliveuser(String username);

}
