package com.normdevstorm.commerce_platform.dto.user;

import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.entity.Address;
import com.normdevstorm.commerce_platform.entity.Payment;
import com.normdevstorm.commerce_platform.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
public class UserResponseDto {
    private UUID userId;
    private String username;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Set<Address> address;
    private Set<Payment> payments;
    private Set<Transaction> transactions;
}
