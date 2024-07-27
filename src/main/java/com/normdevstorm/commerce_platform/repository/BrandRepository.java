package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}