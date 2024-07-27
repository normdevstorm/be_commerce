package com.normdevstorm.commerce_platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data @Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String postalCode;
    @ManyToMany(mappedBy = "address")
    private Set<User> user;
}
