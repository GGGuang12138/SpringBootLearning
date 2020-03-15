package com.example.study.controller;

import com.example.study.dao.EmployeeDao;
import com.example.study.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/list")
    public String list(Model model){



        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("emps",employees);
        return "list";
    }
}
