package com.example.oauth02.mapper;

import com.example.oauth02.dto.UserDto;
import com.example.oauth02.dto.UserDto.UserDtoBuilder;
import com.example.oauth02.entity.RoleEntity;
import com.example.oauth02.entity.UserEntity;
import com.example.oauth02.entity.UserEntity.UserEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2024-11-30T09:18:59+0700", comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)")
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.userId(entity.getId());
        userDto.username(entity.getUsername());
        userDto.password(entity.getPassword());
        userDto.email(entity.getEmail());
        List<RoleEntity> list = entity.getAuthorities();
        if (list != null) {
            userDto.authorities(new ArrayList<RoleEntity>(list));
        }

        return userDto.build();
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email(dto.getEmail());
        userEntity.username(dto.getUsername());
        userEntity.password(dto.getPassword());
        List<RoleEntity> list = dto.getAuthorities();
        if (list != null) {
            userEntity.authorities(new ArrayList<RoleEntity>(list));
        }

        return userEntity.build();
    }
}
