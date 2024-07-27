package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}