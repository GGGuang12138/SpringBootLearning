package com.example.study.dao;

import com.example.study.pojo.Department;

import java.util.Collection;
import java.util.Map;

/**
 * Creat by GG
 * Date on 2020/3/13  9:36 下午
 */
//部门dao
public class DepartmentDao {
    //模拟数据库
    private static Map<Integer,Department> departments;
    static {
        departments.put(101,new Department(101,"1号部门"));
        departments.put(102,new Department(102,"2号部门"));
        departments.put(103,new Department(103,"3号部门"));
        departments.put(104,new Department(104,"4号部门"));
        departments.put(105,new Department(105,"5号部门"));
    }
    //根据id查找部门
    public Department selectById(Integer id){
        return departments.get(id);
    }
    //获得所有部门信息
    public Collection<Department> selectAll(){
        return departments.values();
    }
}
