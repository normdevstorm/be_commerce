package com.normdevstorm.commerce_platform.entity;

import com.normdevstorm.commerce_platform.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "userId")
    private User user;
    private double total;
    private LocalDateTime createAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
}
