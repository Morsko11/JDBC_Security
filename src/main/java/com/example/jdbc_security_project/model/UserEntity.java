package com.example.jdbc_security_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.sql.In;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {


    private String name;
    private Integer id;
    private String lastname;
    private Integer age;

    public UserEntity(String name, String lastname, Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
}
