package com.example.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Creat by GG
 * Date on 2020/3/17  11:52 上午
 */
@RestController
public class JDBCTestController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/test")
    public List<Map<String,Object>> list(){
        String sql = "select * from sys_role";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;

    }
}
