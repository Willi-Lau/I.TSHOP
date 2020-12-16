package com.lwy.demo.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_Admin;
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


    public String selectadmin(String username){

        String password = adminMapper.selectadmin(username);

        return password;
    }

    public List<Clothes> selectallclothespage(){


        return adminMapper.selectallclothespage();
    }

    public int countclothes(){
        return adminMapper.countclothes();
    }

    public Clothes_Admin selectbyid(String id){
        return adminMapper.selectbyid(id);
    }

    public void modifyclothes(Clothes_Admin admin){
        adminMapper.modifyclothes(admin);
    }





}
