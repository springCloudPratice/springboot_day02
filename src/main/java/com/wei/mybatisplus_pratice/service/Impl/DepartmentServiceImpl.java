package com.wei.mybatisplus_pratice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.mybatisplus_pratice.entity.Department;
import com.wei.mybatisplus_pratice.mapper.DepartmentMapper;
import com.wei.mybatisplus_pratice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
