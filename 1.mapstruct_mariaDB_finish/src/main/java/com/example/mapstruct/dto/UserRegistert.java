package com.example.mapstruct.dto;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegistert {
    String fullName;
    String username;
    String password;
    String email;
    String phoneNumber;
    Long avatarId;
    String description;
    Boolean allowLogin;
    int status;
}
