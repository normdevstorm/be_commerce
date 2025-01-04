package com.normdevstorm.commerce_platform.controller.auth;
import com.normdevstorm.commerce_platform.dto.auth.refresh_token.RefreshTokenResponse;
import com.normdevstorm.commerce_platform.dto.auth.signup.SignUpResponseDto;
import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.AuthenticationService;
import com.normdevstorm.commerce_platform.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final JwtService jwtService;

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
            logger.error(e.getMessage());
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