package com.lwy.demo.controller;


import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.Cart_Clothes;
import com.lwy.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/CartController")
@Controller
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/paycartclothes")
    @ResponseBody
    public void paycartclothes(String name){

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
