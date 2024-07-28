package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}