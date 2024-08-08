package com.normdevstorm.commerce_platform.dto.product;

import com.normdevstorm.commerce_platform.entity.Brand;
import com.normdevstorm.commerce_platform.entity.Review;
import com.normdevstorm.commerce_platform.enums.Category;
import com.normdevstorm.commerce_platform.enums.StarRate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class ProductResponseDTO {
    private UUID productId;
    private String name;
    private Category category;
    private Brand brand;
    private long stockQuantity;
    private String desciption;
    private double originalPrice;
    private double salePrice;
    private StarRate starRate;
    private Set<Review> reviews;
    private Map<String, String> otherAttributes;
    private LocalDateTime createdAt;
}
