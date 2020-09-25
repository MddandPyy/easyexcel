package com.example.easyexcel.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private String id;
    private String name;
    private int age;
    private Date birthday;
}
