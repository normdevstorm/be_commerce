package com.normdevstorm.commerce_platform.entity;

import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.CountryCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data @Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID addressId;
    ///todo: auto pass value based on region later
    private String postalCode;
    private CountryCode countryCode;
    @ManyToMany(mappedBy = "address")
    private Set<User> user;
}
