package com.normdevstorm.commerce_platform.mapper.product;
import com.normdevstorm.commerce_platform.dto.cart.CartProductItemResponseDto;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.entity.Cart;
import com.normdevstorm.commerce_platform.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    ProductResponseMapper INSTANCE = Mappers.getMapper( ProductResponseMapper.class );

    ProductResponseDTO toProductResponseDTO(Product product);
//    Product toProduct(ProductResponseDTO productResponseDTO);


    @BeanMapping(
            nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE
    )
    Product partialUpdate(ProductResponseDTO productRequestDTO, @MappingTarget Product product);

}
