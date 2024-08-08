package com.normdevstorm.commerce_platform.entity;

import com.normdevstorm.commerce_platform.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID brandId;
    @NonNull
    private String name;
    @Size(max = 25000)
    private String about;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "brand")
    private Set<Product> products;
}
