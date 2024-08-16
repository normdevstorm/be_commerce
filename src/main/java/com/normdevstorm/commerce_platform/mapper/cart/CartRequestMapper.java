package com.normdevstorm.commerce_platform.mapper.cart;

import com.normdevstorm.commerce_platform.dto.cart.CartRequestDto;
import com.normdevstorm.commerce_platform.entity.Cart;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartRequestMapper {

    Cart toEntity(CartRequestDto cartRequestDto);

    CartRequestDto toDto(Cart cart);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartRequestDto cartRequestDto, @MappingTarget Cart cart);
}