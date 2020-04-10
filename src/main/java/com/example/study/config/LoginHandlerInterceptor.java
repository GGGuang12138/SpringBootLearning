package com.example.study.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creat by GG
 * Date on 2020/3/14  4:18 下午
 */
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object loginedUser = request.getSession().getAttribute("loginedUser");
//        if(loginedUser == null){
//            request.setAttribute("msg","没有权限，请先登陆");
//            request.getRequestDispatcher("/").forward(request,response);//转发
//            return false;
//        }else{
//            return true;
//        }
//
//    }
//
//}
