package com.wei.mybatisplus_pratice.entity;

import lombok.Data;

@Data
public class EmployeeQuery {
    int page;
    int pageSize;
    int dept_id;
}
