package com.normdevstorm.commerce_platform.dto.payment;

import com.normdevstorm.commerce_platform.entity.User;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Payment}
 */
@Value
public class PaymentResponseDto implements Serializable {
    UUID paymentId;
    User user;
    String cardNum;
    LocalDateTime expDate;
    @Size(min = 3, max = 4)
    String cvv;
}