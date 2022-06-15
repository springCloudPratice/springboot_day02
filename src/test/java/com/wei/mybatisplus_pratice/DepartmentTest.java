package com.wei.mybatisplus_pratice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wei.mybatisplus_pratice.entity.Department;
import com.wei.mybatisplus_pratice.mapper.DepartmentMapper;
import com.wei.mybatisplus_pratice.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    public DepartmentMapper departmentMapper;
    @Autowired
    public DepartmentService departmentService;
    List<Department> departmentList=new ArrayList<>();
    @Test
    public void testInsert(){
        Department department = new Department(0, "生活部", "1栋30号");
        departmentList.add(department);
        Department department1 = new Department(0, "生活部", "1栋30号");
        departmentList.add(department1);
        departmentService.saveBatch(departmentList);
    }
    @Test
    public void testSelectAll(){
        List<Department> list = departmentService.list();
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    public void testSelectByCondition(){
        Department department = departmentService.getById(3);
        System.out.println("id为3的部门信息为："+department);
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.in("id",Arrays.asList(1,3));
        List<Department> list = departmentService.list(wrapper);
        System.out.println("id为3或id为5的部门为:"+list);
    }
    @Test
    public void testSelectByWrapper(){
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("name","运行部");
        Department department = departmentService.getOne(wrapper);
        System.out.println("名字为运行部的部门信息为:"+department);
    }
    @Test
    public void testDeleteById(){
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("name","调研部");
        Department department = departmentService.getOne(wrapper);
        Integer id=department.getId();
        int sum = departmentMapper.deleteById(id);
        System.out.println("根据id删除调研部数据，成功与否:"+(sum==1?" 成功":"失败"));
    }

}
