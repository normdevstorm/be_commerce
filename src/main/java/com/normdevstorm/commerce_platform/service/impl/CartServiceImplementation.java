package com.normdevstorm.commerce_platform.service.impl;

import com.normdevstorm.commerce_platform.dto.cart.CartProductItemResponseDto;
import com.normdevstorm.commerce_platform.dto.cart.CartUpdateDto;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.entity.Cart;
import com.normdevstorm.commerce_platform.entity.CartId;
import com.normdevstorm.commerce_platform.entity.Product;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.mapper.cart.CartResponseMapper;
import com.normdevstorm.commerce_platform.mapper.product.ProductResponseMapper;
import com.normdevstorm.commerce_platform.repository.CartRepository;
import com.normdevstorm.commerce_platform.service.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CartServiceImplementation implements CartService {

    private final CartRepository cartRepository;
    private final CartResponseMapper cartResponseMapper;
    private final ProductResponseMapper productResponseMapper;


    @Autowired
    private CartServiceImplementation(CartRepository cartRepository, CartResponseMapper cartResponseMapper, ProductResponseMapper productResponseMapper) {
        this.cartRepository = cartRepository;
        this.cartResponseMapper = cartResponseMapper;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public Set<CartProductItemResponseDto> getAllProductsFromCart() {
        ///todo: note how to get the token from the sec context: after compeleting all ur endpoints
        try {
            User user = claimUserFromToken();
            Cart cart = new Cart();
            Set<Cart> cartProducts = cartRepository.findByCartId_User_UserId(user.getUserId());
            Set<CartProductItemResponseDto> cartProductItemResponseDtoSet = new LinkedHashSet<>();
            for (Cart cartProduct :
                    cartProducts) {
                CartProductItemResponseDto cartProductItemResponseDto = cartResponseMapper.toCartProductItemResponseDto(productResponseMapper.toProductResponseDTO(cartProduct.getCartId().getProduct()), cartProduct.getQuantity());
                cartProductItemResponseDtoSet.add(cartProductItemResponseDto);
            }
            return cartProductItemResponseDtoSet;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<CartProductItemResponseDto> addToCart(Set<CartProductItemResponseDto> cartProductRequestItems) {
        User user = claimUserFromToken();
        Set<CartProductItemResponseDto> currentCart = getAllProductsFromCart();
        Set<Cart> addedProducts = new LinkedHashSet<>();

        try {
            for (CartProductItemResponseDto cartProductItem : cartProductRequestItems
            ) {
                //if exist then not allow to add
                Cart cart = cartResponseMapper.toCartFromCartProductItemResponseDto(cartProductItem, user);
                addedProducts.add(cart);
            }
            cartRepository.saveAll(addedProducts);
            currentCart.addAll(cartProductRequestItems);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return currentCart;
    }

    @Override
    public Set<CartProductItemResponseDto> updateCart(Set<CartProductItemResponseDto> cartProductUpdateItems) {
        try {
            User user = claimUserFromToken();
            for (CartProductItemResponseDto cartUpdateItem : cartProductUpdateItems
            ) {
                Cart cart = cartResponseMapper.toCartFromCartProductItemResponseDto(cartUpdateItem, user);
                cartRepository.updateQuantityByCartId(cart.getQuantity(), cart.getCartId());
            }
            Set<CartProductItemResponseDto> updatedCart = getAllProductsFromCart();
            return updatedCart;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<CartProductItemResponseDto> removeFromCart(Set<String> deleteProductIds) {
        //handle null id case later
        try {
            User user = claimUserFromToken();
            Set<UUID> deleteUUIDs = deleteProductIds.stream().map(id -> UUID.fromString(id)).collect(Collectors.toSet()); ;
            for (UUID deleteProductId : deleteUUIDs
            ) {
                cartRepository.deleteByCartId_Product_ProductIdAndCartId_User_UserId(deleteProductId, user.getUserId());
            }
            Set<CartProductItemResponseDto> updatedCart = getAllProductsFromCart();
            return updatedCart;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String clearCart() {
        try {
            User user = claimUserFromToken();
            cartRepository.deleteByCartId_User_UserId(user.getUserId());
            return "Cart has been cleared !!!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private User claimUserFromToken() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = ((User) authentication.getPrincipal());
            return user;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
    }

}
