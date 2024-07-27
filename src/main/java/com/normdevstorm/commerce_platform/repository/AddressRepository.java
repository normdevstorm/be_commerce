package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}