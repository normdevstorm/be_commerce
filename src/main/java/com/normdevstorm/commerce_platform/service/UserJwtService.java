package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.dto.user.UserPrincipal;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserJwtService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserPrincipal:: new)
                .orElseThrow(() -> new UsernameNotFoundException("UserName not found: " + username));
    }
    public GenericResponse<String> addUserPricipalFromUser(User user)  {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return GenericResponse.<String>builder().success(true).data("Add user successfully").message("Succeeded!!!").build();
    }

}
