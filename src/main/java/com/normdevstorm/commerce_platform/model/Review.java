package com.normdevstorm.commerce_platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reviewId;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "userId")
    private User user;
    private String feedback;
    private LocalDateTime createdAt;
}
