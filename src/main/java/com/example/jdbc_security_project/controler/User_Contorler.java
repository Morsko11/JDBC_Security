package com.example.jdbc_security_project.controler;


import com.example.jdbc_security_project.dto.User_dto;
import com.example.jdbc_security_project.exepshens.User_Not_Find_Eror;
import com.example.jdbc_security_project.model.UserEntity;
import com.example.jdbc_security_project.service.User_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class User_Contorler {

    private final User_Service userService;

    @RequestMapping("/signin")
    private ResponseEntity<HttpStatus> registration(@Valid @RequestBody User_dto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            throw new User_Not_Find_Eror("Пользователь Ввел неправильное имя или фамилию", fieldErrors);
        } else {
            return userService.registration(userDto);
        }
    }

    @ExceptionHandler
    void status(User_Not_Find_Eror userNotFindEror) {
        System.out.println(userNotFindEror.getMessage()+"  "+userNotFindEror.getErors());
    }

    @DeleteMapping("/delete/{name}")
    private void delete(@PathVariable String name ){
        userService.delete(name);
    }
    @RequestMapping("/getId")
    private List<UserEntity> getId(@RequestBody Integer id){
        return userService.getId(id);

    }

}
