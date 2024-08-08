package com.normdevstorm.commerce_platform.mapper.product;
import com.normdevstorm.commerce_platform.dto.product.ProductRequestDTO;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.entity.Product;

public interface ProductRequestMapper {
    ProductRequestDTO toProductRequestDTO(Product product);
    Product toProduct(ProductRequestDTO productRequestDTO);
}
