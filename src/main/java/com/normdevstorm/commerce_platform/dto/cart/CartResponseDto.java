package com.normdevstorm.commerce_platform.dto.cart;

import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Cart}
 */
@Value
public class CartResponseDto implements Serializable {
    UUID user;
    UUID product;
    long quantity;
}