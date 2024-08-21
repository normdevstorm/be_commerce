package com.normdevstorm.commerce_platform.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayPalPaymentResponse {
    private String paymentCreateRedirectUrl;
}
