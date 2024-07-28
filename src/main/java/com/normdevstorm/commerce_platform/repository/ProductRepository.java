package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}