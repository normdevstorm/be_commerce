package com.normdevstorm.commerce_platform.dto.transaction;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import java.util.UUID;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDto {
    ///UUID get from token
    private double total;
    private LocalDateTime createAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
    ///todo: add currency property here later on
}
