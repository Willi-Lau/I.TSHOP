package com.lwy.demo.ExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public String errorHandler(Exception ex) {
        String inf = null;
        //判断异常的类型,返回不一样的返回值
        if(ex instanceof NullPointerException){
            inf  = "die";
        }

        return inf;
    }
}
