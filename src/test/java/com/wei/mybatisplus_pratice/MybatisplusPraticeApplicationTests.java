package com.wei.mybatisplus_pratice;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.wei.mybatisplus_pratice.entity.Employee;
import com.wei.mybatisplus_pratice.mapper.EmployeeMapper;
import com.wei.mybatisplus_pratice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class MybatisplusPraticeApplicationTests {
@Autowired
private EmployeeMapper employeeMapper;
@Autowired
private EmployeeService employeeService;
    @Test
    void contextLoads() {
    }
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Employee> employeeListList = employeeService.list();
        employeeListList.forEach(System.out::println);
    }
    @Test
    public void testGetByOne(){
        System.out.println("执行getByOne方法");
        Employee employee = employeeService.getById(5);
        System.out.println(employee);
    }
}
