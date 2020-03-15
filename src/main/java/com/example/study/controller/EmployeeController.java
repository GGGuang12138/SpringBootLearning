package com.example.study.controller;

import com.example.study.dao.DepartmentDao;
import com.example.study.dao.EmployeeDao;
import com.example.study.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
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

    @RequestMapping("/list.html")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("emps",employees);
        return "/emps/list";
    }
    @GetMapping("/add.html")
    public String addEmpPage(Model model){
        model.addAttribute("departments",departmentDao.selectAll());
        return "/emps/add";
    }
    @PostMapping("/add.html")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/list.html";
    }
}
