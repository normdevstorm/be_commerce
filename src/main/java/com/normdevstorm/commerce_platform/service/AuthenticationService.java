package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.dto.auth.refresh_token.RefreshTokenResponse;
import com.normdevstorm.commerce_platform.dto.auth.signup.SignUpResponseDto;
import com.normdevstorm.commerce_platform.dto.user.UserRequestDto;
import com.normdevstorm.commerce_platform.entity.Key;
import com.normdevstorm.commerce_platform.entity.Payload;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.mapper.auth.signup.SignUpMapper;
import com.normdevstorm.commerce_platform.mapper.user.UserRequestMapper;
import com.normdevstorm.commerce_platform.repository.UserRepository;
import com.normdevstorm.commerce_platform.util.UtilsManager;
import io.jsonwebtoken.Claims;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Log4j2
@Transactional
@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final UserRequestMapper userRequestMapper;
    private final JwtService jwtService;

    private final SignUpMapper signUpMapper;

    private JavaMailSenderImpl mailSender;
    private KeyService keyService;


    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            UserRequestMapper userRequestMapper, JavaMailSenderImpl javaMailSender,
            JwtService jwtService,
            SignUpMapper signUpMapper,
            KeyService keyService
            ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRequestMapper = userRequestMapper;
        this.mailSender = javaMailSender;
        this.jwtService = jwtService;
        this.signUpMapper = signUpMapper;
        this.keyService = keyService;
    }

    public SignUpResponseDto signup(UserRequestDto input) {
        /*
            Register info -> create key pairs -> save users -> build payload -> create token -> return token + user
         */
        User userRequest = userRequestMapper.toUser(input);
        userRequest.setPassword(passwordEncoder.encode(input.getPassword()));
        User user = userRepository.save(userRequest);
        // generate key pair
        Map<String , String> keyPair = jwtService.generateKeyPair();
        String publicKeyPEM = keyPair.get("publicKey");
        String privateKeyPEM = keyPair.get("privateKey");
        // set initial version
        int version = 0;
        Payload payload = Payload.builder().version(0).id(user.getUserId()).role(user.getRole().name()).username(user.getUsername()).version(version).build();
        String accessToken = jwtService.generateAccessToken(payload, privateKeyPEM);
        String refreshToken =  jwtService.generateRefreshToken(payload, privateKeyPEM);
        // save key
        Key key = Key.builder().publicKey(publicKeyPEM).privateKey(privateKeyPEM).user(user).id(user.getUserId()).refreshTokenVersion(version).accessTokenVersion(version).refreshToken(refreshToken).publicKey(publicKeyPEM).privateKey(privateKeyPEM).build();
        keyService.saveKey(key);
        return signUpMapper.toSignUpResponseDto(user, accessToken, refreshToken);
    }

    public RefreshTokenResponse refreshToken(String refreshToken){
        String username = jwtService.extractUsername(refreshToken, true);
        Key key = keyService.getKeyByUsername(username);
        if(key == null){
            throw new RuntimeException("Invalid refresh token");
        }
        String privateKeyPEM = key.getPrivateKey();
        int accessTokenVersion = key.getAccessTokenVersion();

        Payload payloadForAccessToken = Payload.builder().version(accessTokenVersion + 1).id(key.getId()).role(key.getUser().getRole().name()).username(key.getUser().getUsername()).build();
        String accessToken = jwtService.generateAccessToken(payloadForAccessToken, privateKeyPEM);
        key.setAccessTokenVersion(accessTokenVersion + 1);
        keyService.saveKey(key);
        return RefreshTokenResponse.builder().accessToken(accessToken).refreshToken(key.getRefreshToken()).build();
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
