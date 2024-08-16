package com.normdevstorm.commerce_platform.mapper.cart;

import com.normdevstorm.commerce_platform.dto.cart.CartProductItemResponseDto;
import com.normdevstorm.commerce_platform.dto.cart.CartResponseDto;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.entity.Cart;
import com.normdevstorm.commerce_platform.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartResponseMapper {
    Cart toEntity(CartResponseDto cartResponseDto);

    CartResponseDto toDto(Cart cart);


    @Mapping(target = "itemQuantity", source = "itemQuantity")
    @Mapping(target = "productResponseDTO", source = "cartProduct")
    CartProductItemResponseDto toCartProductItemResponseDto(ProductResponseDTO cartProduct, long itemQuantity);

    @Mapping(target = "quantity", source = "cartProductItemResponseDto.itemQuantity")
    @Mapping(target = "cartId.product", source = "cartProductItemResponseDto.productResponseDTO")
    @Mapping(target = "cartId.user", source = "user")
    Cart toCartFromCartProductItemResponseDto(CartProductItemResponseDto cartProductItemResponseDto, User user);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartResponseDto cartResponseDto, @MappingTarget Cart cart);
}