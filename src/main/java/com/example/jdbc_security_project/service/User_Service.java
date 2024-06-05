package com.example.jdbc_security_project.service;

import com.example.jdbc_security_project.dto.User_dto;
import com.example.jdbc_security_project.model.UserEntity;
import com.example.jdbc_security_project.repository.User_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class User_Service {
   private final User_Repository userRepository;
    public ResponseEntity<HttpStatus> registration(User_dto userDto) {
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setLastname(userDto.getLastname());
        return userRepository.registration(user);
    }

    public void delete(String name) {
        userRepository.delete(name);
    }

    public List<UserEntity> getId(Integer id) {
        return userRepository.getId(id);
    }
}
