package com.example.mapstruct.service;

import java.util.Optional;

import com.example.mapstruct.dto.UserRegistert;
import com.example.mapstruct.model.UserEntity;

public interface UserService {
    Optional<UserEntity> findById(Long id);

    UserEntity save(UserRegistert register);
}
