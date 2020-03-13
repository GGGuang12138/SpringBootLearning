package com.example.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Creat by GG
 * Date on 2020/3/13  9:32 下午
 */

//员工

@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer gender; //0女，1男
    private Department department;
    private Date birth;


    public Employee(Integer id, String name, String email, Integer gender, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
    public Employee(Integer id, String name, String email, Integer gender, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birth = new Date();
    }
}
