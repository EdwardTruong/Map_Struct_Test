package com.example.oauth02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.oauth02.dto.UserDto;
import com.example.oauth02.entity.UserEntity;

/**
 * UserMapper
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "entity.id")
    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);

}