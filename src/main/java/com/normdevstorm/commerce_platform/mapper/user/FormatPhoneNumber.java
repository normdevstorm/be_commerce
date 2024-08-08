package com.normdevstorm.commerce_platform.mapper.user;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface FormatPhoneNumber {
    }
