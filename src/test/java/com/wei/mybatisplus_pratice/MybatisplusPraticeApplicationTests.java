package com.wei.mybatisplus_pratice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wei.mybatisplus_pratice.entity.Employee;
import com.wei.mybatisplus_pratice.mapper.EmployeeMapper;
import com.wei.mybatisplus_pratice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Test
    public void testInsert(){
        Employee employee = new Employee(0, "张三", 23, "2558939189@qq.com");
        int insert = employeeMapper.insert(employee);
        System.out.println("插入成功？"+(insert==1?"插入成功":"插入失败"));

    }
    @Test
    public void testUpdateWrapper(){
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("name","李白");
        String name="杜甫";
        Employee employee = new Employee(10086, "李骞", 23, "10086@qq.com");
        int update = employeeMapper.update(employee,wrapper);
        System.out.println(update);
    }
    //删除
    @Test
    public void testDeleteById(){
        int i = employeeMapper.deleteById(1);
        System.out.println(i);
    }
    @Test
    public void testDeleteByWrapper(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("name","杜甫");
        int delete = employeeMapper.delete(wrapper);
        System.out.println(delete);
    }
    @Test
    public void testDeleteBatchIds(){
        employeeMapper.deleteBatchIds(Arrays.asList(4,5));
    }

}

