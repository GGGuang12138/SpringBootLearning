package com.example.study.controller.doctor;

import com.example.study.dto.AccessTokenDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Creat by GG
 * Date on 2020/3/26  10:45 上午
 */
@RestController
public class DoctorUserController {

    @PostMapping("/user/login")
    @ResponseBody
    public AccessTokenDTO login(HttpServletRequest request){
        System.out.println(request.getMethod());
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setAccessToken("asdf");
        accessTokenDTO.setDisplayName("gg");
        String[] strings = new String[2];
        strings[0]="1";
        strings[1]="2";

        accessTokenDTO.setChannels(strings);
        return accessTokenDTO;



    }
}
