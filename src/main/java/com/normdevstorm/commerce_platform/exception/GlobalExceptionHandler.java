package com.normdevstorm.commerce_platform.exception;

import com.normdevstorm.commerce_platform.model.GenericException;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<GenericException> customThrowException(UsernameNotFoundException e){
        GenericException exceptionGenericResponse = GenericException.builder().timestamp(new Date()).status(HttpStatus.NOT_FOUND).details(e.getCause().toString()).message(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionGenericResponse);
    }
    @ExceptionHandler(value = {BadCredentialsException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericException> methodArgumentNotValidException(BadCredentialsException e){
        GenericException exceptionGenericResponse = GenericException.builder().timestamp(new Date()).status(HttpStatus.BAD_REQUEST).details("error").message(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(exceptionGenericResponse);
    }

}
