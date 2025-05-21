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
import java.util.HashMap;
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

   public Map<String, Object> toMap() {
           Map<String, Object> map = new HashMap<>();
           map.put("productId", productId != null ? productId.toString() : null);
           map.put("name", name);
           map.put("category", category != null ? category.name() : null);
           map.put("brand", brand != null ? brand.getBrandId().toString() : null);
           map.put("stockQuantity", stockQuantity);
           map.put("description", desciption);  // Note: preserving the typo from the original field name
           map.put("originalPrice", originalPrice);
           map.put("salePrice", salePrice);
           map.put("starRate", starRate != null ? starRate.name() : null);
           map.put("createdAt", createdAt != null ? createdAt.toString() : null);
           map.put("reviews", !reviews.isEmpty() ? reviews.stream().map(Review::toMap).toList().toString() : null);
           map.put("otherAttributes", otherAttributes != null ? otherAttributes.toString() : null);
           return map;
       }
    // For production environment, it is recommended to leverage json to convert complex objects for at ease conversions, while using hash for granular approaches
//   public static ProductResponseDTO fromMap(Map<String, Object> map) {
//           if (map == null) return null;
//
//           ProductResponseDTO dto = new ProductResponseDTO();
//
//           String productIdStr = (String) map.get("productId");
//           dto.setProductId(productIdStr != null ? UUID.fromString(productIdStr) : null);
//           dto.setName((String) map.get("name"));
//
//           String categoryStr = (String) map.get("category");
//           dto.setCategory(categoryStr != null ? Category.valueOf(categoryStr) : null);
//
//           String brandIdStr = (String) map.get("brand");
//           if (brandIdStr != null) {
//               Brand brand = new Brand();
//               brand.setBrandId(UUID.fromString(brandIdStr));
//               dto.setBrand(brand);
//           }
//
//           dto.setStockQuantity(((Number) map.get("stockQuantity")).longValue());
//           dto.setDesciption((String) map.get("description"));
//           dto.setOriginalPrice(((Number) map.get("originalPrice")).doubleValue());
//           dto.setSalePrice(((Number) map.get("salePrice")).doubleValue());
//
//           String starRateStr = (String) map.get("starRate");
//           dto.setStarRate(starRateStr != null ? StarRate.valueOf(starRateStr) : null);
//
//           String createdAtStr = (String) map.get("createdAt");
//           dto.setCreatedAt(createdAtStr != null ? LocalDateTime.parse(createdAtStr) : null);
//
//           // For complex collections like reviews and otherAttributes,
//           // you may need to implement more sophisticated parsing
//
//           return dto;
//       }

}
