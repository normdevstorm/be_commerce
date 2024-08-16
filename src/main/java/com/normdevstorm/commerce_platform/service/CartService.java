package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.dto.cart.CartProductItemResponseDto;
import com.normdevstorm.commerce_platform.dto.cart.CartUpdateDto;

import java.util.Set;
import java.util.UUID;

public interface CartService {
    public Set<CartProductItemResponseDto> getAllProductsFromCart();

    ///todo: consider to rename request type later on
    public Set<CartProductItemResponseDto> addToCart(Set<CartProductItemResponseDto> cartProductRequestItems);
    public Set<CartProductItemResponseDto> updateCart(Set<CartProductItemResponseDto> cartProductUpdateItems);
    public Set<CartProductItemResponseDto> removeFromCart(Set<String> deleteProductIds);
    public String clearCart();
}
