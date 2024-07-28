package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Cart;
import com.normdevstorm.commerce_platform.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
}