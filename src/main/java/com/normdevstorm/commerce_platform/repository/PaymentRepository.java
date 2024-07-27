package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}