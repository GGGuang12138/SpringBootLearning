package com.example.study.controller;

import com.example.study.mapper.AdminMapper;
import com.example.study.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creat by GG
 * Date on 2020/3/17  11:52 上午
 */
@RestController
public class JDBCTestController {

    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/test")
    public List<Admin> list(){

        List<Admin> adminList = adminMapper.selectAll();
        return adminList;

    }
}
