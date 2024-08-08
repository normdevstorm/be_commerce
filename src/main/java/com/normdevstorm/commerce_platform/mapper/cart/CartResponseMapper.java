package com.normdevstorm.commerce_platform.mapper.cart;

import com.normdevstorm.commerce_platform.dto.cart.CartResponseDto;
import com.normdevstorm.commerce_platform.entity.Cart;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartResponseMapper {
    Cart toEntity(CartResponseDto cartResponseDto);

    CartResponseDto toDto(Cart cart);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartResponseDto cartResponseDto, @MappingTarget Cart cart);
}