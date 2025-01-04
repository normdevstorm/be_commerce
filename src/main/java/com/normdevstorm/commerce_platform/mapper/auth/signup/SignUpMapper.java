package com.normdevstorm.commerce_platform.mapper.auth.signup;

import com.normdevstorm.commerce_platform.dto.auth.signup.SignUpResponseDto;
import com.normdevstorm.commerce_platform.entity.User;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface SignUpMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "accessToken", source= "accessToken")
    @Mapping(target = "refreshToken", source = "refreshToken")
    public SignUpResponseDto toSignUpResponseDto(User user, String accessToken, String refreshToken);

}
