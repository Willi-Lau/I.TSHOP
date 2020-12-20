package com.lwy.demo.bean;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class Usertime {

    private int id;
    private String username;
    private Timestamp time;
}
