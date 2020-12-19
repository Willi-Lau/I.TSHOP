package com.lwy.demo.controller;

import com.lwy.demo.bean.User;

import com.lwy.demo.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/UserController")
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceimpl userService;

    @RequestMapping("/adduserinformation")
    @ResponseBody
    public void adduserinformation(HttpServletRequest request){
        User user = new User();
        user.setUsername(request.getParameter("form[username]"));
        user.setPassword(request.getParameter("form[password]"));
        user.setName(request.getParameter("form[name]"));
        user.setBirthday(request.getParameter("form[birthday]"));
        user.setSex(request.getParameter("form[sex]"));
        user.setPhone(request.getParameter("form[phone]"));
        user.setAddress(request.getParameter("form[address]"));
        user.setEmail(request.getParameter("form[email]"));

        userService.adduserinformation(user);
    }

    @RequestMapping("/checkupdate")
    @ResponseBody
    public String checkupdate(@RequestParam(value = "form[password]") String password_from_form, @RequestParam(value = "form[name]")String name){
        String inf = "no";


        String password_from_sql = null;

        int aliveuser = 0;

        try {
            //这里如果传进来的name 不是数据库里的，传递到Srvice层会触发NullPointerException 所以要进行处理
            password_from_sql = userService.checkupdate(name);
            //查看是否存活
             aliveuser = userService.aliveuser(name);
            //密码对
            if (password_from_sql.equals(password_from_form)){
                //存活
                if(aliveuser == 1){
                    inf = "yes";
                }
                //死亡
                else {
                    inf = "die";
                }

            }
            //密码错误
            else {
                inf= "no";
            }
            System.out.println(name + password_from_sql);

        } catch (NullPointerException e) {
            //找不到引发空指针异常也返回no
            //这种情况是名字根本不在数据库里
            e.printStackTrace();
            inf = "no";

        }



        return inf;

    }


}
