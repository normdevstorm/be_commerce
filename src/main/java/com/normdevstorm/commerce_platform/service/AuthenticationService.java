package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.mapper.user.UserRequestMapper;
import com.normdevstorm.commerce_platform.repository.UserRepository;
import com.normdevstorm.commerce_platform.util.UtilsManager;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;

@Slf4j
@Transactional
@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final UserRequestMapper userRequestMapper;

    private JavaMailSenderImpl mailSender;

    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            UserRequestMapper userRequestMapper, JavaMailSenderImpl javaMailSender) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRequestMapper = userRequestMapper;
        this.mailSender = javaMailSender;
    }

    public User signup(UserRequestDto input) {
        User user = userRequestMapper.toUser(input);
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(UserRequestDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }

    //forgot password feature
    private void updateResetPasswordToken(String token, String email) throws RuntimeException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Could not find any user with the email " + email);
        }
    }

    private User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    private void updatePassword(User user, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
//        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

    private void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("langtocde@gmail.com", "NormDevMerceStorm Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    //    @PostMapping("/forgot_password")]
    @Async
    public String processForgotPassword(HttpServletRequest request) {
        String email = request.getParameter("email");
        String token = RandomStringUtils.randomAlphabetic(50);
        try {
            updateResetPasswordToken(token, email);
            String resetPasswordLink = UtilsManager.getSiteURL(request) + "/reset_password?token=" + token;
            log.info(resetPasswordLink);
            sendEmail(email, resetPasswordLink);
//            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

        } catch (UnsupportedEncodingException | MessagingException e) {
            log.error(e.toString());
            throw new RuntimeException(e.toString());
        } catch (Exception e) {
            log.error(e.toString());
            throw new RuntimeException(e.toString());
        }
        return "Send reset password link to email !!!";
    }

    public String processResetPassword(HttpServletRequest request, String password) {
        String token = request.getParameter("token");
        User user = getByResetPasswordToken(token);
        if (user == null) {
            return "Reset failed !!!";
        } else {
            updatePassword(user, password);
        }
        return "Reset password successfully !!!";
    }
}
