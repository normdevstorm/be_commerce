package com.normdevstorm.commerce_platform.dto.cart;

import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Cart}
 */
@Value
public class CartResponseDto implements Serializable {
    UUID user;
    Set<ProductResponseDTO> products;
    long quantity;
}