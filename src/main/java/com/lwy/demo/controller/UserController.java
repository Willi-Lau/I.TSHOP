package com.lwy.demo.controller;

import com.github.pagehelper.PageHelper;
import com.lwy.demo.bean.User;

import com.lwy.demo.bean.Usertime;
import com.lwy.demo.service.UserService;
import com.lwy.demo.service.impl.UserServiceimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RequestMapping(value = "/UserController")
@RestController
@CrossOrigin
@Api(tags ="用户信息Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("把注册的信息存入数据库")
    @RequestMapping(value = "/adduserinformation",method = RequestMethod.POST)
    public void adduserinformation(@RequestBody  User user){
        userService.adduserinformation(user);
    }

    @ApiOperation("查询登陆账户密码是否正确")
    @RequestMapping(value = "/checkupdate",method = RequestMethod.POST)
    public String checkupdate(@RequestParam(value = "form[password]") String password_from_form, @RequestParam(value = "form[name]")String name){
        String password_from_sql = null;

        int aliveuser = 0;

                //这里如果传进来的name 不是数据库里的，传递到Srvice层会触发NullPointerException 所以要进行处理
                password_from_sql = userService.checkupdate(name);
                //查看是否存活
                aliveuser = userService.aliveuser(name);
                //密码对
                if (password_from_sql.equals(password_from_form)){
                    //存活
                    if(aliveuser == 1){

                        //添加用户登录时间
                        userService.addusertime(name);

                        return "yes";

                    }
                    //死亡
                    else {
                        return "die";
                    }

                }
                //密码错误
                else {
                    return "no";
                }



    }
    @ApiOperation("查询用户登陆历史")
    @RequestMapping(value = "/selectusertime",method = RequestMethod.POST)
    public List<Usertime> selectusertime(@RequestParam(defaultValue = "1") int pageNo,
                                         @RequestParam(defaultValue = "8") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return userService.selectusertime();
    }
    @ApiOperation("查询用户登陆历史条数")
    @RequestMapping(value = "/countusertime",method = RequestMethod.POST)
    public int countusertime() {
        return userService.countusertime();
    }


}
