package com.normdevstorm.commerce_platform.mapper.product;
import com.normdevstorm.commerce_platform.dto.product.ProductRequestDTO;
import com.normdevstorm.commerce_platform.entity.Brand;
import com.normdevstorm.commerce_platform.entity.Product;
import com.normdevstorm.commerce_platform.entity.Review;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(
        componentModel = "spring")
public interface ProductRequestMapper {
    ProductRequestMapper INSTANCE = Mappers.getMapper( ProductRequestMapper.class );

    ProductRequestDTO toProductDto(Product product);
    Product toProduct(ProductRequestDTO productRequestDTO);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "reviews", source = "reviews")
    @Mapping(target = "name", source = "productRequestDTO.name")
    Product toProductWithBrandAndReviews(ProductRequestDTO productRequestDTO, Brand brand, Set<Review> reviews);

    @BeanMapping(
            nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE
    )
    Product partialUpdate(ProductRequestDTO productRequestDTO, @MappingTarget Product product);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "reviews", source = "reviews")
    @Mapping(target = "name", source = "productRequestDTO.name")
    @BeanMapping(
            nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE
    )
    Product partialUpdateWithBrandAndReviews(ProductRequestDTO productRequestDTO, Brand brand, Set<Review> reviews, @MappingTarget Product product);
}
