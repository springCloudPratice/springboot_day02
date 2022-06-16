package com.wei.mybatisplus_pratice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.mybatisplus_pratice.entity.Employee;
import com.wei.mybatisplus_pratice.entity.EmployeeQuery;
import com.wei.mybatisplus_pratice.service.DepartmentService;
import com.wei.mybatisplus_pratice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @Autowired
    public DepartmentService departmentService;
    @PostMapping("/add")
    public String addEmployee(Employee employee){
        System.out.println("接收参数:"+employee);
        boolean save = employeeService.save(employee);
        return save?"添加成功!!!":"添加失败";
    }
    /**
     * 分页查询员工数据
     * @param employeeQuery
     * @return
     */
    @GetMapping("/pageSearch")
    public Page<Employee> showPage(EmployeeQuery employeeQuery){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_id",employeeQuery.getDept_id());
        int page=employeeQuery.getPage();
        int pageSize=employeeQuery.getPageSize();
        Page<Employee> employeePage = new Page<>(page,pageSize);
        employeePage= employeeService.page(employeePage,wrapper);
        for (Employee record : employeePage.getRecords()) {
            record.setDepartment(departmentService.getById(employeeQuery.getDept_id()));
            }
        return employeePage;
    }

}
