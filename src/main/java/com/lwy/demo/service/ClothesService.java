package com.lwy.demo.service;

import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_type;

import java.util.List;

public interface ClothesService {

    public List<Clothes> selectallclothes(String sex);

    public List<String> select_allclothesbrand();

    public int select_maxmoney();

    public List<Clothes> select_dreamclothes(Clothes_type clothes_type);

}
