package com.example.study.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Creat by GG
 * Date on 2020/3/11  10:29 下午
 */
@Component
@Data
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    @Email(message = "格式错了‍")
    private String name;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
}
