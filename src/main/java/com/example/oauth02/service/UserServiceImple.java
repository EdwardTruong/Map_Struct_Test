package com.example.oauth02.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.oauth02.dao.UserRepository;
import com.example.oauth02.dto.UserDto;
import com.example.oauth02.entity.UserEntity;
import com.example.oauth02.exception.UserNotFoundException;
import com.example.oauth02.mapper.UserMapper;
import com.example.oauth02.util.Const.MESSENGER_NOT_FOUND;

@Service
public class UserServiceImple implements UserService {

  @Autowired
  UserRepository userDao;
  
  @Autowired
  UserMapper userMapper;

  @Override
  public List<UserEntity> loadAll() {
    return userDao.findAll();
  }

  @Override
  public UserEntity findById(Integer id) {
    Optional<UserEntity> result = userDao.findById(id);
    return result.orElseThrow(
        () -> new UserNotFoundException(MESSENGER_NOT_FOUND.USER_NOT_FOUND_ID + ": ("
            + id + ")."));
  }

  @Override
  public UserDto findByIdToDto(Integer id) {
    UserEntity entity = findById(id);
    UserDto dto = userMapper.toDto(entity);
    return dto;
  }

  @Override
  public void save(UserEntity entity) {
    userDao.save(entity);
  }

  @Override
  public void update(UserEntity entity) {
    userDao.saveAndFlush(entity);
  }

  @Override
  public void delete(UserEntity entity) {
    userDao.delete(entity);
  }

}
