package com.normdevstorm.commerce_platform.exception.custom.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class CustomJwtException extends RuntimeException {
    public CustomJwtException(String message, Throwable rootCause) {
        super(message, rootCause);}
}
