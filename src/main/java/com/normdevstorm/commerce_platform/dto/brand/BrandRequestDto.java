package com.normdevstorm.commerce_platform.dto.brand;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Brand}
 */
@Value
public class BrandRequestDto implements Serializable {
    UUID brandId;
    String name;
    @Size(max = 25000)
    String about;
}