package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.entity.Brand;
import com.normdevstorm.commerce_platform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Transactional
    @Modifying
    @Query("update Brand b set b.name = ?1, b.about = ?2 where b.brandId = ?3")
    Brand updateNameAndAboutAndProductsByBrandId(String name, String about, @NonNull UUID brandId);
}