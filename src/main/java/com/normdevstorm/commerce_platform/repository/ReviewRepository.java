package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}