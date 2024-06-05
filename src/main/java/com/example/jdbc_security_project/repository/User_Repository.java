package com.example.jdbc_security_project.repository;

import com.example.jdbc_security_project.dto.User_dto;
import com.example.jdbc_security_project.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class User_Repository {
    private final JdbcTemplate jdbcTemplate;

    public ResponseEntity<HttpStatus> registration(UserEntity userEntity) {
         jdbcTemplate.update("INSERT INTO UserEntity (name,lastname,age) VALUES (?,?,?)",userEntity.getName(),userEntity.getLastname(),userEntity.getAge());
         return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public void delete(String name) {
        jdbcTemplate.update("DELETE from userentity where name=?",name);

    }

    public List<UserEntity> getId(Integer id) {
        List<UserEntity> list = new ArrayList<>();
        jdbcTemplate.query("SELECT * from userentity where id=?",new Object[]{id}, (res)->{
            list.add(new UserEntity(res.getString(1),res.getInt(2),res.getString(3),res.getInt(4)));
        });
        return list;
    }
}
