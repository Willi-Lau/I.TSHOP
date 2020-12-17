package com.lwy.demo.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwy.demo.bean.*;
import com.lwy.demo.mapper.AdminMapper;

import com.lwy.demo.util.PageRequest;

import com.lwy.demo.util.PageResult;
import com.lwy.demo.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;


    public String selectadmin(String username){ return adminMapper.selectadmin(username); }

    public List<Clothes> selectallclothespage(){ return adminMapper.selectallclothespage(); }

    public int countclothes(){
        return adminMapper.countclothes();
    }

    public Clothes_Admin selectbyid(String id){
        return adminMapper.selectbyid(id);
    }

    public void modifyclothes(Clothes_Admin admin){
        adminMapper.modifyclothes(admin);
    }

    public List<User> alluserinf(){return adminMapper.alluserinf();}

    public int countuser(){return adminMapper.countuser();}

    public List<Admin> alladmininf(){return adminMapper.alladmininf();}

    public int countadmin(){return  adminMapper.countadmin();}

    public int counttype(String type){return adminMapper.counttype(type); }

    public void insertclothes(AddClothes clothes){  adminMapper.insertclothes(clothes);}

    public String deleteclothes(int id){

        String findsrc = adminMapper.findsrc(id);
        adminMapper.deleteclothes(id);

        return findsrc;
    }

    public List<Clothes> typeselectclothes (AdminClothes clothes){
        return adminMapper.typeselectclothes(clothes);
    }

    public int counttypeselectclothes (AdminClothes clothes){
        return adminMapper.counttypeselectclothes(clothes);
    }

    public void changealive(String username ,int alive){
        adminMapper.changealive(username,alive);
    }

    public List<User> typeselectuser(AdminUser user){ return  adminMapper.typeselectuser(user);}

    public int counttypeselectuser(AdminUser user){ return  adminMapper.counttypeselectuser(user);}
}
