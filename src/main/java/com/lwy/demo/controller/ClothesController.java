package com.lwy.demo.controller;

import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_type;

import com.lwy.demo.service.ClothesService;
import com.lwy.demo.service.impl.ClothesServiceimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/ClothesController")
@Controller
@CrossOrigin
@Api(tags ="前端服装部分Controller")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @ApiOperation("获取所有衣服的信息")
     @RequestMapping(value = "/selectallclothes",method = RequestMethod.POST)
     @ResponseBody
    public List<Clothes> selectallclothes(String sex){
         List<Clothes> list = clothesService.selectallclothes(sex);
         return list;
     }

    @ApiOperation("获取所有衣服品牌")
    @RequestMapping(value = "/select_allclothesbrand",method = RequestMethod.POST)
    @ResponseBody
    public List<String> select_allclothesbrand(){
        List<String> list = clothesService.select_allclothesbrand();
        return list;
    }
    @ApiOperation("获取所有衣服里最高价格")
    @RequestMapping(value = "/select_maxmoney",method = RequestMethod.POST)
    @ResponseBody
    public int select_maxmoney(){
        int i = clothesService.select_maxmoney();
        return i;
    }

    @ApiOperation("条件搜索 根据品牌，性别，最高价最低价进行模糊查询")
    @RequestMapping(value = "/select_dreamclothes",method = RequestMethod.POST)
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
