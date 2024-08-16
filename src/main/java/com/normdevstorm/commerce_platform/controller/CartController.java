package com.normdevstorm.commerce_platform.controller;

import com.normdevstorm.commerce_platform.dto.cart.CartProductItemResponseDto;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.JwtService;
import com.normdevstorm.commerce_platform.service.impl.CartServiceImplementation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cart")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Cart")
public class CartController {

    private CartServiceImplementation cartService;
    private JwtService jwtService;

    @Autowired
    private CartController(CartServiceImplementation cartService,JwtService jwtService){
        this.cartService = cartService;
        this.jwtService = jwtService;
    }

    @GetMapping()
    public ResponseEntity<GenericResponse<Set<CartProductItemResponseDto>>> getProductsFromCart(){
        Set<CartProductItemResponseDto> cartProducts  = cartService.getAllProductsFromCart();
        return ResponseEntity.ok(GenericResponse.<Set<CartProductItemResponseDto>>builder().data(cartProducts).message("Get products from cart successfully !!!").success(true).build());
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse<Set<CartProductItemResponseDto>>> addProductsToCart(@RequestBody Set<CartProductItemResponseDto> cartProductRequestItems){
        Set<CartProductItemResponseDto> cartProducts  = cartService.addToCart(cartProductRequestItems);
        return ResponseEntity.ok(GenericResponse.<Set<CartProductItemResponseDto>>builder().data(cartProducts).message("Add products to cart successfully !!!").success(true).build());
    }

    @PutMapping("/update")
    public ResponseEntity<GenericResponse<Set<CartProductItemResponseDto>>> updateProductsInCart(@RequestBody Set<CartProductItemResponseDto> cartProductUpdateItems){
        Set<CartProductItemResponseDto> cartProducts  = cartService.updateCart(cartProductUpdateItems);
        return ResponseEntity.ok(GenericResponse.<Set<CartProductItemResponseDto>>builder().data(cartProducts).message("Update products in cart successfully !!!").success(true).build());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GenericResponse<Set<CartProductItemResponseDto>>> deleteProductsFromCart(@RequestBody Set<String> deleteProductIds){
        Set<CartProductItemResponseDto> result = cartService.removeFromCart(deleteProductIds);
        return ResponseEntity.ok(GenericResponse.<Set<CartProductItemResponseDto>>builder().data(result).message("Remove from cart successfully !!!").success(true).build());
    }

    @DeleteMapping("/clear")
    public ResponseEntity<GenericResponse<String>> clearCart(){
        String result = cartService.clearCart();
        return ResponseEntity.ok(GenericResponse.<String>builder().data("").message(result).success(true).build());
    }

}
