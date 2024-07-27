package com.normdevstorm.commerce_platform.model;

import com.normdevstorm.commerce_platform.config.validate.CustomValidation;
import com.normdevstorm.commerce_platform.enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.util.Set;
import java.util.UUID;
///todo: research on hibernate inheritance
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @CustomValidation(message = "Password should be valid!!!")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @Column(columnDefinition = "role default 'user'")
    @Enumerated(EnumType.STRING)
    private Role role;
}

