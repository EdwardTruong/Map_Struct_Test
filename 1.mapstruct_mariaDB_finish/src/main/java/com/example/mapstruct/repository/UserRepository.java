package com.example.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapstruct.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
