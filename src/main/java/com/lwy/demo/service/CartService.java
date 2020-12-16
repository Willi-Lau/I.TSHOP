package com.lwy.demo.service;


import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.Cart_Clothes;
import com.lwy.demo.mapper.CartMapper;
import com.lwy.demo.mapper.ClothesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@Transactional
public class CartService {


    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ClothesMapper clothesMapper;


    public void paycartclothes(String name){

            cartMapper.paycartclothes(name);

    }


    public void changecartclothes(Cart cart){
            cartMapper.updatetocart(cart);
            cartMapper.updatetoclothes(cart);
    }



    public List<Cart_Clothes> selectcartclothes(String name){
        List<Cart_Clothes> list = null;

        list = cartMapper.selectcartclothes(name);
        return list;
    }



    public void addtocart(Cart cart){
        int selecttocart = cartMapper.selecttocart(cart);
        if(selecttocart == 0){
            cartMapper.addtocart(cart);
        }
        else{
            cartMapper.updatetocart(cart);
        }

        clothesMapper.updateclothes_whencartadd(cart);
    }

    public void grossmoney(String name,int grossmoney){
        //首先查询总钱数
        int oldgrossmoney = cartMapper.selectgrossmoney(name);
        //重更新计算总钱数
        int newgrossmoney = grossmoney + oldgrossmoney;
        //执行替换
        cartMapper.updategrossmoney(name,newgrossmoney);

    }

}
