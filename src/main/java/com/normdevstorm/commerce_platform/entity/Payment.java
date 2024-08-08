package com.normdevstorm.commerce_platform.entity;

import com.normdevstorm.commerce_platform.config.validate.CustomCreditCardValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID paymentId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userId")
    private User user;
    @CustomCreditCardValidation
    private String  cardNum;
    private LocalDateTime expDate;
    @Size(min = 3, max = 4)
    private String cvv;
}
