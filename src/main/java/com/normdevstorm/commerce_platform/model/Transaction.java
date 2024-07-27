package com.normdevstorm.commerce_platform.model;

import com.normdevstorm.commerce_platform.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user;
    private double total;
    private LocalDateTime createAt;
    private Status status;
}
