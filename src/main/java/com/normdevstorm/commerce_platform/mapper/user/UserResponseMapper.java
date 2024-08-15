package com.normdevstorm.commerce_platform.mapper.user;


import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.dto.user.login.UserResponseDto;
import com.normdevstorm.commerce_platform.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    @Mapping(target = "phoneNumber", source = "userResponseDto.phoneNumber",qualifiedBy = FormatPhoneNumber.class)
    User toUser(UserResponseDto userResponseDto);

    @Mapping(target = "phoneNumber", source = "user.phoneNumber",qualifiedBy = DeformatPhoneNumber.class)
    UserResponseDto toUserDto(User user);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateUserFromDto(UserResponseDto userResponseDto, @MappingTarget User user);

    @FormatPhoneNumber
    public static  String formatPhoneNumber(String unformattedPhoneNumber){
        String firstCluster = unformattedPhoneNumber.substring(1, 3);
        String secondCluster = unformattedPhoneNumber.substring(3, 6);
        String thirdCluster = unformattedPhoneNumber.substring(6);
        String formattedPhoneNumber = "+84" + "-" + firstCluster + "-" + secondCluster + "-" + thirdCluster;
        return formattedPhoneNumber;
    }


    @DeformatPhoneNumber
    public static   String deformatPhoneNumber(String formattedPhoneNumber){
        String firstCluster = formattedPhoneNumber.substring(4, 6);
        String secondCluster = formattedPhoneNumber.substring(7, 10);
        String thirdCluster = formattedPhoneNumber.substring(11);
        String unformattedPhoneNumber = firstCluster + secondCluster + thirdCluster;
        return unformattedPhoneNumber;
    }

}
