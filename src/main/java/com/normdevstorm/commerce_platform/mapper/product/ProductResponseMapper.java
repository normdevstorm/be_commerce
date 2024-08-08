package com.normdevstorm.commerce_platform.mapper.product;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.entity.Product;
public interface ProductResponseMapper {
    ProductResponseDTO toProductResponseDTO(Product product);
    Product toProduct(ProductResponseDTO productResponseDTO);
}
