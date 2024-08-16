package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.entity.Cart;
import com.normdevstorm.commerce_platform.entity.CartId;
import com.normdevstorm.commerce_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
    Set<Cart> findByCartId_User_UserId(@NonNull UUID userId);

    @Transactional
    @Modifying
    @Query("update Cart c set c.quantity = ?1 where c.cartId = ?2")
    int updateQuantityByCartId(@NonNull long quantity, @NonNull CartId cartId);
    @Transactional
    void deleteByCartId_Product_ProductIdAndCartId_User_UserId(@NonNull UUID productId, @NonNull UUID userId);
    @Transactional
    void deleteByCartId_User_UserId(@NonNull UUID userId);
}