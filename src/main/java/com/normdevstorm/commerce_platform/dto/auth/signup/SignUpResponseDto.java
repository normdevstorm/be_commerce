package com.normdevstorm.commerce_platform.dto.auth.signup;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.normdevstorm.commerce_platform.entity.User;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpResponseDto implements Serializable {
    private User user;
    private String accessToken;
    private String refreshToken;
}
