package com.normdevstorm.commerce_platform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 200, message = "Feedback should exceed 300 characters")
    private String feedback;
    private LocalDateTime createdAt;
}
