package com.lwy.demo.controller;

import com.lwy.demo.bean.User;
import com.lwy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/UserController")
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/adduserinformation")
    @ResponseBody
    public void adduserinformation(String [] form){
        User user = new User();
        user.setUsername(form[0]);
        user.setPassword(form[1]);
        user.setName(form[2]);
        user.setBirthday(form[3]);
        user.setSex(form[4]);
        user.setPhone(form[5]);
        user.setAddress(form[6]);
        user.setEmail(form[7]);

        userService.adduserinformation(user);
    }

    @RequestMapping("/checkupdate")
    @ResponseBody
    public String checkupdate(@RequestParam(value = "form[password]") String password_from_form, @RequestParam(value = "form[name]")String name){
        String inf = "no";

        String password_from_sql = userService.checkupdate(name);
        if (password_from_sql.equals(password_from_form)){
            inf = "yes";
        }
        else {
            inf= "no";
        }
        System.out.println(password_from_sql);

        return inf;

    }


}
