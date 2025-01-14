package com.example.mapstruct.model;

import java.math.BigDecimal;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    public static final int MAX_LENGTH_USENAME = 50;
    public static final int MAX_LENGTH_EMAIL = 100;
    public static final int MAX_LENGTH_PHONE_NUMBER = 100;
    public static final int MAX_LENGTH_PASSWORD = 100;
    public static final int MAX_LENGTH_FULLTNAME = 100;
    public static final int MAX_LENGTH_DESCRIPTION = 300;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nationalized
    @Column(name = "full_name", nullable = false, length = MAX_LENGTH_FULLTNAME)
    String fullName;

    @Column(name = "username", nullable = false, length = MAX_LENGTH_USENAME)
    String username;

    @Column(name = "password", nullable = false, length = MAX_LENGTH_PASSWORD)
    String password;

    @Column(name = "email", nullable = false, length = MAX_LENGTH_EMAIL)
    String email;

    @Column(name = "phone_number", length = MAX_LENGTH_PHONE_NUMBER)
    String phoneNumber;

    @JoinColumn(name = "avatar_id", nullable = true)
    Long avatarId;

    @JoinColumn(name = "avatar_id", nullable = true)
    int status;

    @Column(name = "sort_order", nullable = false)
    BigDecimal sortOrder;

    @Column(name = "description", length = MAX_LENGTH_DESCRIPTION)
    String description;

    @ColumnDefault("true")
    @Column(name = "allow_login", nullable = false)
    Boolean allowLogin;

    @Column(name = "is_super_admin")
    Boolean isSuperAdmin = false;

}