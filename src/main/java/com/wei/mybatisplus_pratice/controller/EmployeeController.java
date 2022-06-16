package com.wei.mybatisplus_pratice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.mybatisplus_pratice.entity.Employee;
import com.wei.mybatisplus_pratice.entity.EmployeeQuery;
import com.wei.mybatisplus_pratice.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public String addEmployee(Employee employee){
        System.out.println("接收参数:"+employee);
        boolean save = employeeService.save(employee);
        return save?"添加成功!!!":"添加失败";
    }
    @GetMapping("/pageSearch")
    public Page<Employee> showPage(EmployeeQuery employeeQuery){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_id",employeeQuery.getDept_id());
        int page=employeeQuery.getPage();
        int pageSize=employeeQuery.getPageSize();
        Page<Employee> EmployeePage = new Page<>(page,pageSize);
        EmployeePage= employeeService.page(EmployeePage,wrapper);
        return EmployeePage;
    }

}
