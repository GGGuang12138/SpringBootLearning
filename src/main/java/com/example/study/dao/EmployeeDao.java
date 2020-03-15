package com.example.study.dao;

import com.example.study.pojo.Department;
import com.example.study.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Creat by GG
 * Date on 2020/3/13  9:40 下午
 */
@Repository
public class EmployeeDao {
    //模拟数据
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"1号","10086@qq.com",0,new Department(101,"1号部门")));
        employees.put(1002,new Employee(1002,"2号","10087@qq.com",1,new Department(102,"2号部门")));
        employees.put(1003,new Employee(1003,"3号","10088@qq.com",0,new Department(103,"3号部门")));
        employees.put(1004,new Employee(1004,"4号","10089@qq.com",1,new Department(104,"4号部门")));
        employees.put(1005,new Employee(1005,"5号","10085@qq.com",0,new Department(105,"5号部门")));

    }
    @Autowired
    private DepartmentDao departmentDao;
    //主键
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.selectById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> selectAll(){
        return employees.values();
    }

    //根据id查询员工
    public Employee selectById(Integer id){
        return employees.get(id);
    }

    //根据id删除员工
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
