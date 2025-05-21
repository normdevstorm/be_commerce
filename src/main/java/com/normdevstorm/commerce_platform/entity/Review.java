package com.normdevstorm.commerce_platform.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review{
    ///update review later, composite key = userId, productId, createdAt
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reviewId;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "userId")
//    @JsonIncludeProperties(value = "userId")
    @JsonIgnoreProperties(value = {"username", "password", "role", "firstName","lastName","phoneNumber","address","payments","transactions","enabled","authorities","accountNonExpired",  "credentialsNonExpired","accountNonLocked"})
    private User user;
    @Size(max = 200, message = "Feedback should exceed 300 characters")
    private String feedback;
    private LocalDateTime createdAt;

public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("reviewId", reviewId != null ? reviewId.toString() : null);
        map.put("user", user != null ? user.getUserId().toString() : null);
        map.put("feedback", feedback);
        map.put("createdAt", createdAt != null ? createdAt.toString() : null);
        return map;
    }
}
