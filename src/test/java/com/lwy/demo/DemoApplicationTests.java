package com.lwy.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads(HttpServletRequest request) {
        System.out.println(request.getServletContext().getContextPath());

    }

}
