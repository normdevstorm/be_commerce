package com.normdevstorm.commerce_platform.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.normdevstorm.commerce_platform.dto.brand.BrandRequestDto;
import com.normdevstorm.commerce_platform.dto.review.ReviewRequestDto;
import com.normdevstorm.commerce_platform.entity.Brand;
import com.normdevstorm.commerce_platform.entity.Review;
import com.normdevstorm.commerce_platform.enums.Category;
import com.normdevstorm.commerce_platform.enums.StarRate;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
@Data
public class ProductRequestDTO implements Serializable {
//    private UUID productId;
    @NonNull
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Nullable
    @JsonIgnoreProperties(value = {"products", "brandId"})
    private BrandRequestDto brand;
    private long stockQuantity;
    @Size(max = 15000)
    private String desciption;
    private double originalPrice;
    private double salePrice;
    private StarRate starRate;
    @JsonIgnoreProperties(value = {"reviewId"})
    private Set<ReviewRequestDto> reviews;
    private Map<String, String> otherAttributes;
    @NonNull
    ///todo: assign the current time later on
    private LocalDateTime createdAt;
}
