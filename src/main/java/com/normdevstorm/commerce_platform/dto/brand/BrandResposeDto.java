package com.normdevstorm.commerce_platform.dto.brand;

import com.normdevstorm.commerce_platform.entity.Product;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Brand}
 */
@Value
public class BrandResposeDto implements Serializable {
    UUID brandId;
    String name;
    @Size(max = 25000)
    String about;
    Set<Product> products;
}