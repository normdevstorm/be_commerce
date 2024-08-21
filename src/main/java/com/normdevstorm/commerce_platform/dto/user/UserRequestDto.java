package com.normdevstorm.commerce_platform.dto.user;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.normdevstorm.commerce_platform.config.validate.CustomPasswordValidation;
import com.normdevstorm.commerce_platform.config.validate.CustomPhoneNumValidation;
import com.normdevstorm.commerce_platform.dto.payment.PaymentRequestDto;
import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.entity.Address;
import com.normdevstorm.commerce_platform.entity.Payment;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;

@Data
public class UserRequestDto {
    @NotBlank(message = "Username is mandatory")
    private String username;
//    @CustomPasswordValidation(message = "Password should be valid!!!")
//    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Value("USER")
    private Role role;
    @NotBlank
    @Size(max = 50, message = "Name should not exceed 50 character length")
    private String firstName;
    @NotBlank
    @Size(max = 50, message = "Name should not exceed 50 character length")
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @Email
    private String email;
    @Nullable
    @JsonIgnoreProperties("user")
    private Set<Address> address;
    @Nullable
    @JsonIgnoreProperties("user")
    private Set<PaymentRequestDto> payments;
}
