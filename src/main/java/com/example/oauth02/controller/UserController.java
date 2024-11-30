package com.example.oauth02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.oauth02.dto.UserDto;
import com.example.oauth02.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/info/{id}")
  public ResponseEntity<UserDto> userInfo(@PathVariable("id") Integer id) {
    UserDto dto = userService.findByIdToDto(id);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

}
