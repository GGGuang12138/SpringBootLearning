package com.example.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Creat by GG
 * Date on 2020/3/14  3:04 下午
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session
    ){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("loginedUser",username);//给登陆权限，并保存
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号或密码输入错误");
            return "index";
        }
    }
}
