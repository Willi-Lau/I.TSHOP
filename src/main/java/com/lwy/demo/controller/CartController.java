package com.lwy.demo.controller;


import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.CartHistory;
import com.lwy.demo.bean.Cart_Clothes;

import com.lwy.demo.service.impl.CartServiceompl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/CartController")
@Controller
@CrossOrigin
public class CartController {

    @Autowired
    private CartServiceompl cartService;

    @RequestMapping("/paycartclothes")
    @ResponseBody
    public void paycartclothes(String name){
         //查询购物车所有的货物
        List<Cart_Clothes> selectcartclothes = cartService.selectcartclothes(name);

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        String nowday = Integer.toString(year)+"/"+Integer.toString(month)+"/"+Integer.toString(day);
        //把货物添加到历史货物里
        for(Cart_Clothes cart_clothes : selectcartclothes){
            CartHistory cartHistory = new CartHistory();
            cartHistory.setDay(nowday);
            cartHistory.setId(cart_clothes.getClothes_id());
            cartHistory.setMoney(cart_clothes.getClothes_money());
            cartHistory.setUsername(name);
            cartHistory.setNum(cart_clothes.getCart_num());
            cartHistory.setSrc(cart_clothes.getClothes_src());

            cartService.addcarthistory(cartHistory);
        }


        //删除
           cartService.paycartclothes(name);

    }

    @RequestMapping("/changecartclothes")
    @ResponseBody
    public void changecartclothes(HttpServletRequest request){
        Cart cart = new Cart();
        cart.setId(Integer.parseInt(request.getParameter("clothes_id")));
        cart.setNum(Integer.parseInt(request.getParameter("num")));
        cart.setUsername(request.getParameter("name"));
        cartService.changecartclothes(cart);
    }


    @RequestMapping("/selectcartclothes")
    @ResponseBody
    public List<Cart_Clothes> selectcartclothes(String name){
        List<Cart_Clothes> list = null;
        list = cartService.selectcartclothes(name);

        return list;
    }


    @RequestMapping("/addtocart")
    @ResponseBody
    public void addtocart(HttpServletRequest request){

        Cart cart = new Cart();
        cart.setId(Integer.parseInt(request.getParameter("id")));
        cart.setNum(Integer.parseInt(request.getParameter("cart_num")));
        cart.setUsername(request.getParameter("name"));
        cartService.addtocart(cart);
    }
    @RequestMapping("/grossmoney")
    @ResponseBody
    public void grossmoney(String name,int grossmoney){
        cartService.grossmoney(name,grossmoney);
    }



}
