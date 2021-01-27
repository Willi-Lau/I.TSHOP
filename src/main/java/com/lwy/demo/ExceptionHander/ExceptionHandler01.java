package com.lwy.demo.ExceptionHander;

import org.apache.ibatis.binding.BindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理所有的异常
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandler01 {



    //User 信息返回时查询不到 alive 为null
    @ExceptionHandler(value=BindingException.class)
    @ResponseBody
    private String exceptionHandlerBinding(BindingException e){


        System.out.println("BindingException！！！");
        return "no";

    }

    //User 传进来在数据库找不到
    @ExceptionHandler(value=NullPointerException.class)
    @ResponseBody
    private String exceptionHandlerNullPinter(NullPointerException e){


        System.out.println("NullPointerException异常！！！");

        return "no";

    }

    //总异常
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    private String exceptionHandler(Exception e){

        e.printStackTrace();
        System.out.println("Exception异常！！！");
        return "no";

    }




}
