package com.example.mapstruct.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapstruct.dto.UserRegistert;
import com.example.mapstruct.model.UserEntity;
import com.example.mapstruct.repository.UserRepository;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public Optional<UserEntity> findById(Long id) {

        return userDao.findById(id);
    }

    @Override
    public UserEntity save(UserRegistert register) {
        UserEntity entity = UserEntity.builder()
                .allowLogin(register.getAllowLogin())
                .avatarId(register.getAvatarId())
                .description(register.getDescription())
                .email(register.getEmail())
                .fullName(register.getFullName())
                .phoneNumber(register.getPhoneNumber())
                .username(register.getUsername())
                .password(register.getPassword())
                .status(register.getStatus())
                .sortOrder(BigDecimal.ZERO)
                .build();
        userDao.save(entity);
        entity.setSortOrder(BigDecimal.valueOf(entity.getId()));
        userDao.saveAndFlush(entity);
        return entity;
    }

}
