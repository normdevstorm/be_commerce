package com.normdevstorm.commerce_platform.controller.user;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.dto.user.UserResponseDto;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/create")
    public UserResponseDto createUser(@Valid  @RequestBody UserRequestDto userRequestDto){
       return userService.createUser(userRequestDto);
    }
}
