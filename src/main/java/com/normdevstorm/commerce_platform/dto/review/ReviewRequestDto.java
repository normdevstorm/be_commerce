package com.normdevstorm.commerce_platform.dto.review;

import com.normdevstorm.commerce_platform.entity.User;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.normdevstorm.commerce_platform.entity.Review}
 */
@Value
public class ReviewRequestDto implements Serializable {
    User user;
    @Size(message = "Feedback should exceed 300 characters", max = 200)
    String feedback;
    LocalDateTime createdAt;
}