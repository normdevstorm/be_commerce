package com.normdevstorm.commerce_platform.model;
import com.normdevstorm.commerce_platform.enums.Category;
import com.normdevstorm.commerce_platform.enums.StarRate;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    @NonNull
    private String name;
    ///todo: add value later on
    @Enumerated(EnumType.STRING)
    private Category category;
    @Nullable
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "brand_id")
    private Brand brand;
    @NonNull
    private long stockQuantity;
    private String desciption;
    @NonNull
    private double originalPrice;
    private double salePrice;
    private StarRate starRate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Review> reviews;
    // persist a map type with this annotation
    @ElementCollection
    private Map<String, String> otherAttributes;
    @NonNull
    private LocalDateTime createdAt;
}
