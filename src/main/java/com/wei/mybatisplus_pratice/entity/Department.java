package com.wei.mybatisplus_pratice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
    Integer id;
    String name;
    String address;
    Integer sn;
}
