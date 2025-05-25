package com.normdevstorm.commerce_platform.controller.auth;
import com.normdevstorm.commerce_platform.dto.auth.refresh_token.RefreshTokenResponse;
import com.normdevstorm.commerce_platform.dto.auth.signup.SignUpResponseDto;
import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.AuthenticationService;
import com.normdevstorm.commerce_platform.service.JwtService;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RequestMapping("/auth")
@RestController
@Log4j2
public class AuthenticationController {
    final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity register(@RequestBody UserRequestDto registerUserDto) {
        try{
        SignUpResponseDto signUpResponseDto = authenticationService.signup(registerUserDto);
         GenericResponse<SignUpResponseDto> genericResponse =  GenericResponse.<SignUpResponseDto>builder().data(signUpResponseDto).success(true).message("Sign up successfully").build();
        return ResponseEntity.ok(genericResponse);
        } catch (ResponseStatusException e){
            log.error(e.getMessage());
           return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public void authenticate(@RequestBody UserRequestDto loginUserDto) {
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<RefreshTokenResponse> refreshToken(@RequestBody Map<String, String> refreshToken) {
         RefreshTokenResponse refreshTokenResponse = authenticationService.refreshToken(refreshToken.get("refresh_token"));
         return ResponseEntity.ok(refreshTokenResponse);
    }
}