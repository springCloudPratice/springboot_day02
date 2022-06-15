package com.wei.mybatisplus_pratice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.mybatisplus_pratice.entity.Employee;
import com.wei.mybatisplus_pratice.mapper.EmployeeMapper;
import com.wei.mybatisplus_pratice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
}
