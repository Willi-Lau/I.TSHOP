package com.lwy.demo.service.impl;

import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_type;
import com.lwy.demo.mapper.ClothesMapper;
import com.lwy.demo.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClothesServiceimpl implements ClothesService {

    @Autowired
    private ClothesMapper clothesMapper;

    public List<Clothes> selectallclothes(String sex){
        List<Clothes> list = clothesMapper.select_allmen(sex);
        return list;


    }

    public List<String> select_allclothesbrand(){
        List<String> list = clothesMapper.select_allclothesbrand();
        return list;
    }

    public int select_maxmoney(){
        int i = clothesMapper.select_maxmoney();
        return i;
    }

    public List<Clothes> select_dreamclothes(Clothes_type clothes_type){
        List<Clothes> list = clothesMapper.select_dreamclothes(clothes_type);

        return list;
    }
}
