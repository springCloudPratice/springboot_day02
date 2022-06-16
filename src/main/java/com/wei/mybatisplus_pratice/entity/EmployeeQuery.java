package com.wei.mybatisplus_pratice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeQuery {
    int page;
    int pageSize;
    int dept_id;
}
