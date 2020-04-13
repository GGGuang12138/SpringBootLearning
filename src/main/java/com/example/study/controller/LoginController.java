package com.example.study.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
            Model model
            //HttpSession session
    ){

        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            //session.setAttribute("loginedUser",username);//给登陆权限，并保存
            return "redirect:/main.html";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "index";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "index";
        }
    }
    @RequestMapping("loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "redirect:/ ";
    }
}
