package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
}