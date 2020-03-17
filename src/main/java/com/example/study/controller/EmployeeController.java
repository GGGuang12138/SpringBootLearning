package com.example.study.controller;

import com.example.study.dao.DepartmentDao;
import com.example.study.dao.EmployeeDao;
import com.example.study.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Creat by GG
 * Date on 2020/3/14  9:54 下午
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    //员工列表
    @RequestMapping("/list.html")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("emps",employees);
        return "/emps/list";
    }
    //添加页面
    @GetMapping("/add.html")
    public String addEmpPage(Model model){
        model.addAttribute("departments",departmentDao.selectAll());
        return "/emps/add";
    }
    //完成添加
    @PostMapping("/add.html")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/list.html";
    }
    //编辑页面
    @GetMapping("/edit.html/{id}")
    public String editEmpPage(@PathVariable(name = "id")Integer id, Model model){
        Employee employee = employeeDao.selectById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("departments",departmentDao.selectAll());
        return "/emps/edit";
    }
    //完成编辑
    @PostMapping("/edit.html")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/list.html";
    }
    //删除员工
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Integer id){
        employeeDao.deleteById(id);
        return "redirect:/list.html";
    }
}
