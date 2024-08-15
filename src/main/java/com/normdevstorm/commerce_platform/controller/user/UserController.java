package com.normdevstorm.commerce_platform.controller.user;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.dto.user.login.UserResponseDto;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.JwtService;
import com.normdevstorm.commerce_platform.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController()
@RequestMapping("/user")
@SecurityRequirement(name="bearerAuth")
@Tag(name = "User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;
    @Operation(description = "Partially update user explicit information")

    @PatchMapping(value = "/edit")
    public ResponseEntity<GenericResponse<UserResponseDto>> editUserInformation(@Valid @RequestBody UserRequestDto userRequestDto){
       UserResponseDto userResponseDto = userService.editUserInformation(userRequestDto);
       return ResponseEntity.ok(GenericResponse.<UserResponseDto>builder().success(true).data(userResponseDto).message("").build());
    }
}
