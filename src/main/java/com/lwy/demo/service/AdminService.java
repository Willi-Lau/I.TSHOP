package com.lwy.demo.service;

import com.lwy.demo.bean.*;

import java.util.List;

public interface AdminService {
    String selectadmin(String username);

    List<Clothes> selectallclothespage();

    int countclothes();

    Clothes_Admin selectbyid(String id);

    void modifyclothes(Clothes_Admin admin);

    List<User> alluserinf();

    int countuser();

    List<Admin> alladmininf();

    int countadmin();

    int counttype(String type);

    void insertclothes(AddClothes clothes);

    String deleteclothes(int id);

    List<Clothes> typeselectclothes(AdminClothes clothes);

    int counttypeselectclothes(AdminClothes clothes);

    void changealive(String username, int alive);

    List<User> typeselectuser(AdminUser user);

    int counttypeselectuser(AdminUser user);

    String [] alluserinfusername();

     String [] alluserinfgrossmoney();

    List<CartHistory> selectallcarthistory();

    void addadmintime(String username);

}
