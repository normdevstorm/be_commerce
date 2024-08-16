package com.normdevstorm.commerce_platform.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.normdevstorm.commerce_platform.entity.Brand;
import com.normdevstorm.commerce_platform.entity.Review;
import com.normdevstorm.commerce_platform.enums.Category;
import com.normdevstorm.commerce_platform.enums.StarRate;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponseDTO implements Serializable {
    private UUID productId;
    private String name;
    private Category category;
    @JsonIgnoreProperties("products")
    private Brand brand;
    private long stockQuantity;
    private String desciption;
    private double originalPrice;
    private double salePrice;
    private StarRate starRate;
    @ElementCollection
//    @JsonIgnoreProperties("user")
    private Set<Review> reviews;
    private Map<String, String> otherAttributes;
    private LocalDateTime createdAt;
}
