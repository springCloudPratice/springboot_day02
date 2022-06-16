package com.wei.mybatisplus_pratice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("employee")
public class Employee implements Serializable {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    int age;
    String email;
    Integer dept_id;
    //如果字段属性不存在，忽略
    @TableField(exist = false)
    Department department;
}
