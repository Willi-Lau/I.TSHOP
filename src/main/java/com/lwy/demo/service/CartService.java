package com.lwy.demo.service;

import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.CartHistory;
import com.lwy.demo.bean.Cart_Clothes;

import java.util.List;

public interface CartService {

    void paycartclothes(String name);

    void changecartclothes(Cart cart);

    List<Cart_Clothes> selectcartclothes(String name);

    void addtocart(Cart cart);

    void grossmoney(String name, int grossmoney);

    void addcarthistory(CartHistory cartHistory);


}
