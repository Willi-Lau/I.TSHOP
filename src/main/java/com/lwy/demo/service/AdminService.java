package com.lwy.demo.service;

import com.lwy.demo.bean.*;

import java.util.List;

public interface AdminService {
    public String selectadmin(String username);

    public List<Clothes> selectallclothespage();

    public int countclothes();

    public Clothes_Admin selectbyid(String id);

    public void modifyclothes(Clothes_Admin admin);

    public List<User> alluserinf();

    public int countuser();

    public List<Admin> alladmininf();

    public int countadmin();

    public int counttype(String type);

    public void insertclothes(AddClothes clothes);

    public String deleteclothes(int id);

    public List<Clothes> typeselectclothes (AdminClothes clothes);

    public int counttypeselectclothes (AdminClothes clothes);

    public void changealive(String username ,int alive);

    public List<User> typeselectuser(AdminUser user);

    public int counttypeselectuser(AdminUser user);

    public String [] alluserinfusername();

    public String [] alluserinfgrossmoney();
}
