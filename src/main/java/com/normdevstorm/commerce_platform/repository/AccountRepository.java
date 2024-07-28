package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}