package com.lwy.demo.controller;


import com.github.pagehelper.PageHelper;
import com.lwy.demo.bean.*;
import com.lwy.demo.service.AdminService;
import com.lwy.demo.service.impl.AdminServiceimpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@CrossOrigin
@RequestMapping(value = "/AdminController")
@Api(tags = "所有后台 管理员端的Controller")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/typeselectclothes",method = RequestMethod.POST)
    @ApiOperation("根据传递进来的id,brand,type进行查询。空则查询所有")
    public List<Clothes> typeselectclothes(@RequestParam(value = "form[id]") int id,
                                           @RequestParam(value = "form[brand]") String brand,
                                           @RequestParam(value = "form[type]") String type,
                                           @RequestParam(defaultValue = "1") int pageNo,
                                           @RequestParam(defaultValue = "6") int pageSize

    ){
        PageHelper.startPage(pageNo,pageSize);
        AdminClothes clothes = new AdminClothes();
        clothes.setBrand(brand);
        clothes.setId(id);
        clothes.setType(type);
        List<Clothes> list =   adminService.typeselectclothes(clothes);
//        System.out.println(list);
        return list;


    }

    @ApiOperation("根据传递进来的id,brand,type进行查询时数据的个数")
    @RequestMapping(value = "/counttypeselectclothes",method = RequestMethod.POST)
    public int counttypeselectclothes (@RequestParam(value = "form[id]",defaultValue = "0") int id,
                                       @RequestParam(value = "form[brand]") String brand,
                                       @RequestParam(value = "form[type]") String type
                                       ){

        AdminClothes clothes = new AdminClothes();
        clothes.setBrand(brand);
        clothes.setId(id);
        clothes.setType(type);
        return adminService.counttypeselectclothes(clothes);
    }


    @ApiOperation("查询管理员账户密码是否正确")
    @RequestMapping(value = "/selectadmin",method = RequestMethod.POST)
    public String selectadmin(@RequestParam(value = "form[password]") String password ,@RequestParam(value = "form[name]") String username){
        String inf ="no";

            String selecpassword = adminService.selectadmin(username);
            if (selecpassword.equals(password)){
                inf = "yes";
                //写入当前登陆时间      MYSQL自动记录时间，传入名字就可以
                adminService.addadmintime(username);
            }
            else {
                inf = "no";
            }


        return inf;
    }

    @ApiOperation("分页查询所有的衣服")
    @RequestMapping(value = "/selectallclothes",method = RequestMethod.POST)
    public List<Clothes> selectallclothes(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "6") int pageSize){
        //pageNo 是要查询的页数，现在每一页有6个数据
        //根据传递进来的pageNo 返回数据
        PageHelper.startPage(pageNo,pageSize);
        return  adminService.selectallclothespage();


    }

    @ApiOperation("查蓄奴所有衣服的数量")
    @RequestMapping(value = "/countclothes",method = RequestMethod.POST)
    public int countclothes(){
        return  adminService.countclothes();
    }

    @ApiOperation("根据指定id查询")
    @RequestMapping(value = "/selectbyid",method = RequestMethod.POST)
    public Clothes_Admin selectbyid(String id){
        return adminService.selectbyid(id);
    };

    @ApiOperation("修改衣服属性")
    @RequestMapping(value = "/modifyclothes",method = RequestMethod.POST)
    public void midifyclothes(@RequestBody  Clothes_Admin admin){
        adminService.modifyclothes(admin);
    }

    @ApiOperation("查询所有的用户信息 分页")
    @RequestMapping(value = "/alluserinf",method = RequestMethod.POST)
    public List<User> alluserinf(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<User> list = adminService.alluserinf();
        System.out.println(list);
        return list;
    }

    @ApiOperation("查询所有用户信息，不分页")
    @RequestMapping(value = "/alluserinfnotpage",method = RequestMethod.POST)
    public List<User> alluserinfnotpage(){

        List<User> list = adminService.alluserinf();

        return list;
    }

    @ApiOperation("查找所有的用户名")
    @RequestMapping(value = "/alluserinfusername",method = RequestMethod.POST)
    public String [] alluserinfusername(){return  adminService.alluserinfusername();}

    @ApiOperation("查找所有的消费")
    @RequestMapping(value = "/alluserinfgrossmoney",method = RequestMethod.POST)
    public String [] alluserinfgrossmoney(){return  adminService.alluserinfgrossmoney();}

    @ApiOperation("统计用户个数")
    @RequestMapping(value = "/countuser",method = RequestMethod.POST)
    public int countuser(){
        return adminService.countuser();
    }

    @ApiOperation("所有管理员信息")
    @RequestMapping(value = "/alladmininf",method = RequestMethod.POST)
    public List<Admin> alladmininf(){return adminService.alladmininf();}

    @ApiOperation("统计管理员个数")
    @RequestMapping(value = "/countadmin",method = RequestMethod.POST)
    public int countadmin(){return  adminService.countadmin();}


    @ApiOperation("上传衣服的信息 单文件上传")
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    public void load( AddClothes addClothes ,MultipartFile uploadFile) throws IOException {

        //获取文件名字
        String originalFilename = uploadFile.getOriginalFilename();
        //设置路径
        String a = System.getProperty("user.dir");
        a = a+"\\src\\main\\vue\\vue_cli\\src\\assets\\clothes\\";
        //根据性别，计算自动生成文件的名字
        //男 b  女 c 童 d
        //首先统计此性别的衣服的个数
        int counttype = adminService.counttype(addClothes.getType());

        String filename = "";
        //衣服名字应该加 1
        if(addClothes.getType().equals("男")){
            filename = "b"+Integer.toString(counttype+1)+".jpg";
        }
        if(addClothes.getType().equals("女")){
            filename = "c"+Integer.toString(counttype+1)+".jpg";
        }
        if(addClothes.getType().equals("童")){
            filename = "d"+Integer.toString(counttype+1)+".jpg";
        }
        addClothes.setSrc(filename);
        //上传文件
        uploadFile.transferTo(new File(a+filename));
        //把文件信息写入数据库
        adminService.insertclothes(addClothes);
    }

    @ApiOperation("删除衣服 IO删除")
    @RequestMapping(value = "/deleteclothes",method = RequestMethod.POST)
    public void deleteclothes(String id){
        //在数据库中删除 返回文件的路径
        String filesrc = adminService.deleteclothes(Integer.parseInt(id));
        //在本地文件中删除照片
        //拼接完整类路径
        String a = System.getProperty("user.dir");
        a = a+"\\src\\main\\vue\\vue_cli\\src\\assets\\clothes\\"+filesrc;

        //执行删除
        File file = new File(a);
        if(file.exists()){
            file.delete();
        }
    }

    @ApiOperation("改变用户是否禁用")
    @RequestMapping(value = "/changealive",method = RequestMethod.POST)
    public void changealive(String username,int alive){
        adminService.changealive(username,alive);
    }

    @ApiOperation("根据用户信息查询 空则查询所有")
    @RequestMapping(value = "/typeselectuser",method = RequestMethod.POST)
    public List<User> typeselectuser(@RequestParam(defaultValue = "1") int pageNo,
                                     @RequestParam(defaultValue = "8") int pageSize,
                                     @RequestParam(value = "form[username]") String username,
                                     @RequestParam(value = "form[name]") String name
                                     ){
        PageHelper.startPage(pageNo,pageSize);
        AdminUser user = new AdminUser();
        user.setName(name);
        user.setUsername(username);

        return  adminService.typeselectuser(user);}

    @ApiOperation("条件查询用户返回数量")
    @RequestMapping(value = "/counttypeselectuser",method = RequestMethod.POST)
    public int counttypeselectuser(@RequestParam(value = "form[username]") String username,
                                   @RequestParam(value = "form[name]") String name){
        AdminUser user = new AdminUser();
        user.setName(name);
        user.setUsername(username);

        return  adminService.counttypeselectuser(user);}

    @ApiOperation("查询购物车历史记录")
    @RequestMapping(value = "/selectallcarthistory",method = RequestMethod.POST)
    public List<CartHistory> selectallcarthistory() {

        return adminService.selectallcarthistory();
    }


    @ApiOperation("查询管理员历史登陆")
    @RequestMapping(value = "/selectadmintime",method = RequestMethod.POST)
    public List<Admintime> selectadmintime(@RequestParam(defaultValue = "1") int pageNo,
                                           @RequestParam(defaultValue = "8") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return  adminService.selectadmintime();
    }
    @ApiOperation("统计管理员历史登录条数")
    @RequestMapping(value = "/countadmintime",method = RequestMethod.POST)
    public int countadmintime() {
        return  adminService.countadmintime();
    }
}
