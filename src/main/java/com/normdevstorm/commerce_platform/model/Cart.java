package com.normdevstorm.commerce_platform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import java.util.UUID;

///todo: note down  composite key, how to define , use and persist
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartId.class)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID product;
    @NotNull
    private long quantity;
}
