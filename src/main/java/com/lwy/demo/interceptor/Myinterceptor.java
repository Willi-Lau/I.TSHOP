package com.lwy.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Myinterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //注意：这里设置只允许http://locahost:8081进行跨域访问
        request.setCharacterEncoding("utf-8");
        //http://locahost:8081:它表示的是前端的服务地址
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8081");   //设置允许响应地址
        response.setHeader("Access-Control-Allow-Credentail","true");
        response.setHeader("Access-Control-Allow-Methods","GET, PUT, DELETE, POST");
        response.setHeader("Access-Control-Max-Age","3628800");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization");   //设置允许响应的头信息


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
