package com.example.oauth02.dto;

import java.util.List;

import com.example.oauth02.entity.RoleEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    int userId;
    String username;
    String password;
    String email;
    List<RoleEntity> authorities;

}
