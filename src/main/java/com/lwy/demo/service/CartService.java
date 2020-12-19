package com.lwy.demo.service;

import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.Cart_Clothes;

import java.util.List;

public interface CartService {

    public void paycartclothes(String name);

    public void changecartclothes(Cart cart);

    public List<Cart_Clothes> selectcartclothes(String name);

    public void addtocart(Cart cart);

    public void grossmoney(String name,int grossmoney);
}
