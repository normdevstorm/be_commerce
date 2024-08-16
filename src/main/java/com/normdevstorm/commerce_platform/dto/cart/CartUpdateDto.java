package com.normdevstorm.commerce_platform.dto.cart;

import com.normdevstorm.commerce_platform.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartUpdateDto {
    private UUID productId;
    private long quantity;
}
