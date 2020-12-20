package com.lwy.demo.bean;


import lombok.Data;

import java.util.Date;

@Data
public class CartHistory {

    private String username;
    private int id;
    private int num;
    private int money;
    private String day;
    private String src;
}
