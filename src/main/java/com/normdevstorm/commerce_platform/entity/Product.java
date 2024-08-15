              package com.normdevstorm.commerce_platform.entity;
import com.normdevstorm.commerce_platform.enums.Category;
import com.normdevstorm.commerce_platform.enums.StarRate;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;
//    @NonNull
    private String name;
//    @Enumerated(EnumType.STRING)
    private Category category;
//    @Nullable
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "brandId")
    private Brand brand;
    private long stockQuantity;
//    @Size(max = 15000)
    private String desciption;
    private double originalPrice;
    private double salePrice;
    private StarRate starRate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Review> reviews;
    // persist a map type with this annotation
    @ElementCollection
    private Map<String, String> otherAttributes;
//    @NonNull
    private LocalDateTime createdAt;
}
