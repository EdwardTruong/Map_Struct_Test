package com.example.mapstruct.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.dto.UserRegistert;
import com.example.mapstruct.exception.UserNotFoundException;
import com.example.mapstruct.mapper.UserMapper;
import com.example.mapstruct.model.UserEntity;
import com.example.mapstruct.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long userId) {
        UserEntity user = userService.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("with id : " + userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserEntity> saveNew(@RequestBody UserRegistert register) {
        UserEntity user = userService.save(register);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}