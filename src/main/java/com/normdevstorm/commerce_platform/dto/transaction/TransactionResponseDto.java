package com.normdevstorm.commerce_platform.dto.transaction;

import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.Status;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Transaction}
 */
@Value
public class TransactionResponseDto implements Serializable {
    UUID transactionId;
    User user;
    double total;
    LocalDateTime createAt;
    Status status;
}