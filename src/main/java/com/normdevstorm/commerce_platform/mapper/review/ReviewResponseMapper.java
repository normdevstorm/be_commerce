package com.normdevstorm.commerce_platform.mapper.review;

import com.normdevstorm.commerce_platform.dto.review.ReviewResponseDto;
import com.normdevstorm.commerce_platform.entity.Review;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewResponseMapper {
    Review toEntity(ReviewResponseDto reviewResponseDto);

    ReviewResponseDto toDto(Review review);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Review partialUpdate(ReviewResponseDto reviewResponseDto, @MappingTarget Review review);
}