package com.wei.mybatisplus_pratice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    int id;
    String name;
    int age;
    String email;
}
