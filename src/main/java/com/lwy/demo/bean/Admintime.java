package com.lwy.demo.bean;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Timestamp;


@Data
public class Admintime {

    private int id;
    private String username;
    private Timestamp time;
}
