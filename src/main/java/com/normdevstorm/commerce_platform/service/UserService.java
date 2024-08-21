package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.dto.user.login.UserResponseDto;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.mapper.user.UserRequestMapper;
import com.normdevstorm.commerce_platform.mapper.user.UserResponseMapper;
import com.normdevstorm.commerce_platform.repository.UserRepository;
import com.normdevstorm.commerce_platform.util.UtilsManager;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;
    private final JwtService jwtService;
    private final JavaMailSenderImpl mailSender;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(
            UserRepository userRepository,
            UserResponseMapper userResponseMapper,
            UserRequestMapper userRequestMapper,
            JwtService jwtService,
            JavaMailSenderImpl mailSender,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
        this.jwtService = jwtService;
        this.mailSender = mailSender;
        this.passwordEncoder = passwordEncoder;
    }

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

    public UserResponseDto findByUsername(String username) {
        return userResponseMapper.toUserDto(userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found !!!")));
    }

    //password reset
    public String passwordReset(String currentPassword, String newPassword) {
        authenticateCurrentPassword(currentPassword);
        ///todo: remove duplicate code later on
        User user = claimUserFromToken();
        Integer isSuccess = userRepository.updatePasswordByUserId(passwordEncoder.encode(newPassword), user.getUserId());
        ///todo: perfrom a post password reset action (logout) later
        return UtilsManager.toBoolean(isSuccess) ? "Update password successfully!!!" : "Update password failed!!!";
    }

    // authen token
    // request: cur pass, new pass (re-type new pass -> confirm assign for FE validating)
    private boolean authenticateCurrentPassword(String currentPassword) {
        try {
            User user = claimUserFromToken();
            return user.getPassword().equals(passwordEncoder.encode(currentPassword));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //forgot password
//    private

    private User claimUserFromToken() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = ((User) authentication.getPrincipal());
            return user;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
    }
//    //forgot password feature
//    private void updateResetPasswordToken(String token, String email) throws RuntimeException {
//        User user = userRepository.findByEmail(email);
//        if (user != null) {
//            user.setResetPasswordToken(token);
//            userRepository.save(user);
//        } else {
//            throw new RuntimeException("Could not find any user with the email " + email);
//        }
//    }
//
//    private User getByResetPasswordToken(String token) {
//        return userRepository.findByResetPasswordToken(token);
//    }
//
//    private void updatePassword(User user, String newPassword) {
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        user.setPassword(encodedPassword);
//        user.setResetPasswordToken(null);
//        userRepository.save(user);
//    }
//
//    private void sendEmail(String recipientEmail, String link)
//            throws MessagingException, UnsupportedEncodingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        helper.setFrom("langtocde@gmail.com", "NormDevMerceStorm Support");
//        helper.setTo(recipientEmail);
//
//        String subject = "Here's the link to reset your password";
//
//        String content = "<p>Hello,</p>"
//                + "<p>You have requested to reset your password.</p>"
//                + "<p>Click the link below to change your password:</p>"
//                + "<p><a href=\"" + link + "\">Change my password</a></p>"
//                + "<br>"
//                + "<p>Ignore this email if you do remember your password, "
//                + "or you have not made the request.</p>";
//
//        helper.setSubject(subject);
//
//        helper.setText(content, true);
//
//        mailSender.send(message);
//    }
//
//    //    @PostMapping("/forgot_password")]
//    @Async
//    public String processForgotPassword(HttpServletRequest request) {
//        String email = request.getParameter("email");
//        String token = RandomStringUtils.randomAscii(30);
//        try {
//            updateResetPasswordToken(token, email);
//            String resetPasswordLink = UtilsManager.getSiteURL(request) + "/reset_password?token=" + token;
//
//            sendEmail(email, resetPasswordLink);
////            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
//
//        } catch (UnsupportedEncodingException | MessagingException e) {
//            log.error(e.toString());
//            throw new RuntimeException(e.toString());
//        } catch (Exception e) {
//            log.error(e.toString());
//            throw new RuntimeException(e.toString());
//        }
//        return "Send reset password link to email !!!";
//    }
//
//    public String processResetPassword(HttpServletRequest request, String password) {
//        String token = request.getParameter("token");
//        User user = getByResetPasswordToken(token);
//        if (user == null) {
//            return "Reset failed !!!";
//        } else {
//            updatePassword(user, password);
//        }
//        return "Reset password successfully !!!";
//    }
}
