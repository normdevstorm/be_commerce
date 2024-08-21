package com.normdevstorm.commerce_platform.dto.user.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.entity.Address;
import com.normdevstorm.commerce_platform.entity.Payment;
import com.normdevstorm.commerce_platform.entity.Transaction;
import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
public class UserResponseDto implements Serializable {
    private UUID userId;
    private String username;
    private Role role;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @Nullable
    @JsonIgnoreProperties("user")
    private Set<Address> address;
    @Nullable
    @JsonIgnoreProperties("user")
    private Set<Payment> payments;
    @Nullable
    @JsonIgnoreProperties("user")
    private Set<Transaction> transactions;
}
