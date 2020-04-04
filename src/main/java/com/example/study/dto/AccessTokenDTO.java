package com.example.study.dto;

import lombok.Data;

/**
 * Creat by GG
 * Date on 2020/3/26  7:52 下午
 */
@Data
public class AccessTokenDTO {
    private String accessToken;
    private String displayName;
    private String[] channels;
}
