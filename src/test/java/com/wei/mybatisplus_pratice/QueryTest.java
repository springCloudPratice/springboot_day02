package com.wei.mybatisplus_pratice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.mybatisplus_pratice.entity.Employee;
import com.wei.mybatisplus_pratice.mapper.EmployeeMapper;
import com.wei.mybatisplus_pratice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class QueryTest {
    @Autowired
    public EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeService employeeService;
    @Test
    public void testPageQuery(){
        IPage<Employee> page=new Page<>(1,5);
        page = employeeMapper.selectPage(page, null);
        List<Employee> records = page.getRecords();
        System.out.println("分页每页显示的记录数:"+page.getSize());
        for (Employee record : records) {
            System.out.println(record);
        }
    }
    @Test
    public void testCase1(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("name","赵").or().gt("age",25);
        Page<Employee> page = new Page<>(1,5);
        page= employeeService.page(page, wrapper);
        List<Employee> records = page.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }
    }
    //统计每个部门的人数
    @Test
    public void testCase2(){
        //select dept_id,count(dept_id) from employee group by dept_id
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.select("dept_id,count(dept_id) ct")
        .groupBy("dept_id");
        List<Map<String, Object>> maps = employeeMapper.selectMaps(wrapper);
        for (Map<String, Object> map : maps) {
            System.out.println("部门id:"+map.get("dept_id")+"  部门人数:"+map.get("ct"));
        }
    }

}
