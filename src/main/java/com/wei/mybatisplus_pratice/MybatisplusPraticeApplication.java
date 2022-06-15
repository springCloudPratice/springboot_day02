package com.wei.mybatisplus_pratice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wei.mybatisplus_pratice.mapper")
public class MybatisplusPraticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusPraticeApplication.class, args);
    }

}
