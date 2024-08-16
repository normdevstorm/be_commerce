package com.normdevstorm.commerce_platform.dto.cart;

import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductItemResponseDto {
    private ProductResponseDTO productResponseDTO;
    private long itemQuantity;
}
