package com.lwy.demo.controller;


import com.github.pagehelper.PageHelper;
import com.lwy.demo.bean.*;
import com.lwy.demo.service.AdminService;
import com.lwy.demo.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/alluserinf")
    @ResponseBody
    public List<User> alluserinf(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        return adminService.alluserinf();
    }

    @RequestMapping(value = "/countuser")
    @ResponseBody
    public int countuser(){
        return adminService.countuser();
    }

    @RequestMapping(value = "/alladmininf")
    @ResponseBody
    public List<Admin> alladmininf(){return adminService.alladmininf();}

    @RequestMapping(value = "/countadmin")
    @ResponseBody
    public int countadmin(){return  adminService.countadmin();}

    //上传文件
    //单文件上传
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    @ResponseBody
    public void load(HttpServletRequest request,MultipartFile uploadFile) throws IOException {

        AddClothes addClothes = new AddClothes();

        addClothes.setMoney(Integer.parseInt(request.getParameter("money")));
        addClothes.setNum(Integer.parseInt(request.getParameter("num")));
        addClothes.setBrand(request.getParameter("brand"));
        addClothes.setInfo(request.getParameter("info"));
        addClothes.setType(request.getParameter("type"));

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
    @ResponseBody
    @RequestMapping(value = "/deleteclothes")
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

}
