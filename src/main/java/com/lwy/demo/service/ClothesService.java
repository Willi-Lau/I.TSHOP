package com.lwy.demo.service;

import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_type;

import java.util.List;

public interface ClothesService {

    List<Clothes> selectallclothes(String sex);

    List<String> select_allclothesbrand();

    int select_maxmoney();

    List<Clothes> select_dreamclothes(Clothes_type clothes_type);

}
