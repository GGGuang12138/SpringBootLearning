package com.example.study.config.ShiroConfig;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Creat by GG
 * Date on 2020/4/10  10:54 下午
 */
@Configuration
public class ShiroConfig {
    //创建安全管理器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器,讲过滤规则添加到filterMap即可

        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/emps/add.html","perms[user:add]");
        filterMap.put("/main.html","authc");
        filterMap.put("/emps/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登陆页面
        bean.setLoginUrl("/");
        //不授权页面
        bean.setUnauthorizedUrl("/");
        return bean;
    }
    //管理器连接userRealm
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
