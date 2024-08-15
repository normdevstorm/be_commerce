package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.dto.user.login.UserResponseDto;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.mapper.user.UserRequestMapper;
import com.normdevstorm.commerce_platform.mapper.user.UserResponseMapper;
import com.normdevstorm.commerce_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserResponseMapper userResponseMapper;
    @Autowired
    private UserRequestMapper userRequestMapper;
    @Autowired
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userRepository.save(userRequestMapper.toUser(userRequestDto));
        return userResponseMapper.toUserDto(user);
    }

    public void saveUser(User user) {
        User sample = User.builder().username("normdev_@12345").firstName("nguyen").lastName("nam").password(passwordEncoder.encode("Aa1!aaBb")).phoneNumber("0392955340").role(Role.USER).build();
        userRepository.save(sample);
        userRepository.save(user);
    }

    public UserResponseDto editUserInformation(UserRequestDto userRequestDto) {
        User user = userRepository.findByUsername(userRequestDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRequestMapper.partialUpdate(userRequestDto, user);
        userRepository.save(user);
        return userResponseMapper.toUserDto(user);
    }
}
