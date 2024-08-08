package com.normdevstorm.commerce_platform.mapper.user;


import com.normdevstorm.commerce_platform.dto.user.UserResponseDto;
import com.normdevstorm.commerce_platform.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    User toUser(UserResponseDto userResponseDto);
    UserResponseDto toUserResponseDto(User user);
}
