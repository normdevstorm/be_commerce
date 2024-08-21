package com.normdevstorm.commerce_platform.dto.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.Status;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Transaction}
 */
@Value
@Builder
public class TransactionResponseDto implements Serializable {
    UUID transactionId;
    UUID userId;
    double total;
    LocalDateTime createAt;
    String description;
    Status status;
}