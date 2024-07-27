package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}