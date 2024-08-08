package com.normdevstorm.commerce_platform.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class GenericResponse<T> {
    private boolean success;
    private String message;
    private T data;
}