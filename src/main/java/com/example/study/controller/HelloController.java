package com.example.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Creat by GG
 * Date on 2020/3/11  2:22 下午
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "index";

    }
}
