package com.lwy.demo.controller;

import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_type;

import com.lwy.demo.service.impl.ClothesServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/ClothesController")
@Controller
@CrossOrigin
public class ClothesController {

    @Autowired
    private ClothesServiceimpl clothesService;

     @RequestMapping("/selectallclothes")
     @ResponseBody
    public List<Clothes> selectallclothes(String sex){
         List<Clothes> list = clothesService.selectallclothes(sex);
         return list;
     }

    @RequestMapping("/select_allclothesbrand")
    @ResponseBody
    public List<String> select_allclothesbrand(){
        List<String> list = clothesService.select_allclothesbrand();
        return list;
    }

    @RequestMapping("/select_maxmoney")
    @ResponseBody
    public int select_maxmoney(){
        int i = clothesService.select_maxmoney();
        return i;
    }

    @RequestMapping("/select_dreamclothes")
    @ResponseBody
    public List<Clothes> select_dreamclothes(HttpServletRequest request){
        Clothes_type clothes_type= new Clothes_type();



        clothes_type.setBrand(request.getParameter("form[brand]"));
        clothes_type.setType(request.getParameter("form[resource]"));
        clothes_type.setMoney_max(Integer.parseInt(request.getParameter("form[money][1]")));
        clothes_type.setMoney_min(Integer.parseInt(request.getParameter("form[money][0]")));

        List<Clothes> list = clothesService.select_dreamclothes(clothes_type);

        return list;
    }


}
