package com.example.jdbc_security_project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
public class User_dto {
    @Size(min = 3,max = 30,message = "неправильно длина имя")
    @NotEmpty
    private String name;
    @NotEmpty
    @Size(min = 3,max = 30,message = "неправильно,длина fam")
    private String lastname;
    @NotNull
    @Min(12)
    @Max(110)
    private Integer age;
}
