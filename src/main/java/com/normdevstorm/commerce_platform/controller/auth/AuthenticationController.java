package com.normdevstorm.commerce_platform.controller.auth;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.model.auth.response.LoginResponse;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.AuthenticationService;
import com.normdevstorm.commerce_platform.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        User registeredUser = authenticationService.signup(registerUserDto);
         GenericResponse<User> genericResponse =  GenericResponse.<User>builder().data(registeredUser).success(true).message("Sign up successfully").build();
        return ResponseEntity.ok().body(genericResponse);
        } catch (ResponseStatusException e){
            logger.error(e.getMessage());
           return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<GenericResponse> authenticate(@RequestBody UserRequestDto loginUserDto) {
        try{
            User authenticatedUser = authenticationService.authenticate(loginUserDto);
            String jwtToken = jwtService.generateToken(authenticatedUser);
            LoginResponse loginResponse = new LoginResponse().builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();;
            GenericResponse genericResponse = GenericResponse.builder().message("Login succeeded!!!").success(true).data(loginResponse).build();
            jwtService.extractClaim(jwtToken, claims -> claims.getSubject());
            return ResponseEntity.ok(genericResponse);
        } catch (UsernameNotFoundException e){
            logger.error(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        } catch (BadCredentialsException e){
            logger.error(e.getMessage());
            throw new BadCredentialsException(e.getMessage());
        }
    }
}