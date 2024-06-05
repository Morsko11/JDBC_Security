package com.example.jdbc_security_project.exepshens;

import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User_Not_Find_Eror extends RuntimeException{
    private String message;
    private List<FieldError> erors;


}
