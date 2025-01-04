package com.normdevstorm.commerce_platform.config.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.entity.Key;
import com.normdevstorm.commerce_platform.entity.Payload;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.repository.UserRepository;
import com.normdevstorm.commerce_platform.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

// Handle login only
public class LocalAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    //TODO : config snakecase for objectmapper to use it as bean
    private final ObjectMapper objectMapper = new ObjectMapper();
    public LocalAuthenticationFilter(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository, String filterProcessesUrl) {
        super(authenticationManager);
        super.setFilterProcessesUrl(filterProcessesUrl);
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // retrieve username + password
        try {
            UserRequestDto requestBody = new ObjectMapper().readValue(request.getInputStream(), UserRequestDto.class);
            String username = requestBody.getUsername();
            String password = requestBody.getPassword();

            UsernamePasswordAuthenticationToken authenticationRequest = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationManager authenticationManager = getAuthenticationManager();
            return authenticationManager.authenticate(authenticationRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        /*
            get username -> get keys -> gen tokens
         */
        User userPrinciple =  (User)authResult.getPrincipal();
        String username = userPrinciple.getUsername();
        User userWithKey = userRepository.findByUsername(username).orElseThrow();

        Key key = userWithKey.getKey();
        String privateKeyPEM = key.getPrivateKey();
        UUID id = userWithKey.getUserId();


        // Build Payload, Version ++
        String role = userWithKey.getRole().name();
        Integer refreshTokenVersion = key.getRefreshTokenVersion() + 1;
        Integer accessTokenVersion = key.getAccessTokenVersion() + 1;
        Payload payloadForAccessToken = Payload.builder().version(accessTokenVersion).id(id).role(role).username(username).build();
        Payload payloadForRefreshToken = Payload.builder().version(refreshTokenVersion).id(id).role(role).username(username).build();

        String accessToken = jwtService.generateAccessToken(payloadForAccessToken, privateKeyPEM);
        String refreshToken = jwtService.generateRefreshToken(payloadForRefreshToken, privateKeyPEM);
        jwtService.updateRefreshToken(refreshToken, id);
        jwtService.updateRefreshTokenVersion(id, refreshTokenVersion);
        jwtService.updateAccessTokenVersion(id, refreshTokenVersion);

        Map<String, String> tokens = Map.of("accessToken", accessToken, "refreshToken", refreshToken);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(GenericResponse.builder().success(true).data(tokens).message("Login succeeded").build()));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(GenericResponse.builder().success(false).message("Login failed").build()));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
