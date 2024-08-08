package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    Address findByAddressId(@NonNull UUID addressId);
}