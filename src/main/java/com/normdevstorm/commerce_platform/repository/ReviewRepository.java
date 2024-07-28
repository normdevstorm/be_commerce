package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}