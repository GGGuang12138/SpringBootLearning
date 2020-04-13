package com.example.study.config.ShiroConfig;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Creat by GG
 * Date on 2020/4/10  10:51 下午
 */
//自定义的 UserRealm类
public class UserRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        //新建授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取单前登陆用户
        Subject subject = SecurityUtils.getSubject();
        Object primaryPrincipal1 = subject.getPrincipal();

        String str = String.valueOf(primaryPrincipal1);
        if("".equals(str)|| str==null){
            return null;
        }else{
            info.addStringPermission(String.valueOf(primaryPrincipal1));
            return info;
        }


    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");
        //用户密码获取
        //管理员
        String username = "admin";
        String password = "admin";
        String perms = "";

//        String username = "admin";
//        String password = "admin";

        //用户名认证
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        if(!userToken.getUsername().equals(username)){
            return null; //抛出用户名错误异常
        }

        //密码认证
        return new SimpleAuthenticationInfo(perms,password,"");
    }
}
