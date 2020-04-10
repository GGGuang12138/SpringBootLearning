package com.example.study.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

/**
 * Creat by GG
 * Date on 2020/4/10  10:39 上午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //请求授权规则
        http.authorizeRequests().antMatchers("/main.html").permitAll()
                .antMatchers("/list.html").hasRole("admin");

        //默认开启登陆验证页面
        http.formLogin().loginPage("/").loginProcessingUrl("/login");

        //注销


        ////开启注销功能
        http.logout().logoutSuccessUrl("/");
    }


    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("admin");
    }
}
