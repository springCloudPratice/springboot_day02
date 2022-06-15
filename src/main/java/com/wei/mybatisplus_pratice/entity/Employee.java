package com.wei.mybatisplus_pratice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("employee")
public class Employee implements Serializable {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    int age;
    String email;
}
