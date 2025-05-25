package com.normdevstorm.commerce_platform.util.interceptors;

import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Log4j2
@Component
public class HeaderInterceptor implements HandlerInterceptor {
//    @Autowired
//    private JwtService jwtService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        return HandlerInterceptor.super.preHandle(request, response, handler);
//        try {
//            String token = request.getHeader("Authorization").substring(7);
//            UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) request.getUserPrincipal();
//            jwtService.isTokenValid(token, user.getName());
//            return HandlerInterceptor.super.preHandle(request, response, handler);
//        } catch (Exception exception) {
//            throw exception;
//        }
//    }
}
