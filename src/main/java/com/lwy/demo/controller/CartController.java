package com.lwy.demo.controller;


import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.CartHistory;
import com.lwy.demo.bean.Cart_Clothes;

import com.lwy.demo.service.CartService;
import com.lwy.demo.service.impl.CartServiceompl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/CartController")
@RestController
@CrossOrigin
@Api(tags ="购物车端的Controller")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation("支付钱，删除数据库里购物车信息，添加到历史购物车中")
    @RequestMapping(value = "/paycartclothes",method = RequestMethod.POST)
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

    @ApiOperation("修改购物车")
    @RequestMapping(value = "/changecartclothes")
    public void changecartclothes(@RequestParam(value = "clothes_id") int id,int num,String name){
        Cart cart = new Cart();
        cart.setId(id);
        cart.setNum(num);
        cart.setUsername(name);
        cartService.changecartclothes(cart);
    }

    @ApiOperation("查看指定用户购物车")
    @RequestMapping(value = "/selectcartclothes",method = RequestMethod.POST)
    public List<Cart_Clothes> selectcartclothes(String name){
        List<Cart_Clothes> list = null;
        list = cartService.selectcartclothes(name);

        return list;
    }

    @ApiOperation("添加到购物车")
    @RequestMapping(value = "/addtocart",method = RequestMethod.POST)
    public void addtocart(int id,int cart_num,String name){

        Cart cart = new Cart();
        cart.setId(id);
        cart.setNum(cart_num);
        cart.setUsername(name);
        cartService.addtocart(cart);
    }

    @ApiOperation("修改指定用户总消费")
    @RequestMapping(value = "/grossmoney",method = RequestMethod.POST)
    public void grossmoney(String name,int grossmoney){
        cartService.grossmoney(name,grossmoney);
    }



}
