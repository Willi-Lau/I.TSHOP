package com.lwy.demo.controller;


import com.github.pagehelper.PageHelper;
import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_Admin;
import com.lwy.demo.service.AdminService;
import com.lwy.demo.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@CrossOrigin
@RequestMapping(value = "/AdminController")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    //查询管理员账户密码是否正确
    @RequestMapping("/selectadmin")
    @ResponseBody
    public String selectadmin(@RequestParam(value = "form[password]") String password ,@RequestParam(value = "form[name]") String username){
        String inf ="no";
        try {
            String selecpassword = adminService.selectadmin(username);
            if (selecpassword.equals(password)){
                inf = "yes";
            }
            else {
                inf = "no";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inf;
    }

    @RequestMapping(value = "/selectallclothes")
    @ResponseBody
    public List<Clothes> selectallclothes(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "6") int pageSize){
        //pageNo 是要查询的页数，现在每一页有10个数据
        //根据传递进来的pageNo 返回数据
        PageHelper.startPage(pageNo,pageSize);
        return  adminService.selectallclothespage();


    }


    @RequestMapping(value = "/countclothes")
    @ResponseBody
    public int countclothes(){
        return  adminService.countclothes();
    }


    @RequestMapping(value = "/selectbyid")
    @ResponseBody
    public Clothes_Admin selectbyid(String id){
        return adminService.selectbyid(id);
    };


    @RequestMapping(value = "/modifyclothes")
    @ResponseBody
    public void midifyclothes(HttpServletRequest request){
        Clothes_Admin admin = new Clothes_Admin();
        admin.setId(Integer.parseInt(request.getParameter("form[id]")));
        admin.setMoney(Integer.parseInt(request.getParameter("form[money]")));
        admin.setNum(Integer.parseInt(request.getParameter("form[num]")));
        admin.setBrand(request.getParameter("form[brand]"));
        admin.setInfo(request.getParameter("form[info]"));
        admin.setType(request.getParameter("form[type]"));
        adminService.modifyclothes(admin);
    }

}
