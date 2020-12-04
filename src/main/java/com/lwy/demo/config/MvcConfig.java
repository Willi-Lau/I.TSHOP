package com.lwy.demo.config;

import com.lwy.demo.interceptor.Myinterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {


    //注入拦截器
    @Bean
    public Myinterceptor myinterceptor(){
        return new Myinterceptor();
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myinterceptor()).addPathPatterns("/*");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true)  // 这里一定要设置为true，才能覆盖原来的默认的xml format
                .defaultContentType(MediaType.APPLICATION_JSON);
    }
}
