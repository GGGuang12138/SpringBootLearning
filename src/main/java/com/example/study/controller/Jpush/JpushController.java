package com.example.study.controller.Jpush;

import com.example.study.util.JpushUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creat by GG
 * Date on 2020/4/4  6:49 下午
 */
@RestController
public class JpushController {

    @Autowired
    private JpushUtil jpushUtil;

    @GetMapping("/jpush")
    public String jpush(){
        jpushUtil.pushNotice("all","all","瞧瞧看看");
        return "收到";
    }
}
