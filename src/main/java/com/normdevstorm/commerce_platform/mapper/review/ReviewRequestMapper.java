package com.normdevstorm.commerce_platform.mapper.review;

import com.normdevstorm.commerce_platform.dto.review.ReviewRequestDto;
import com.normdevstorm.commerce_platform.entity.Review;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewRequestMapper {
    Review toEntity(ReviewRequestDto reviewRequestDto);

    ReviewRequestDto toDto(Review review);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Review partialUpdate(ReviewRequestDto reviewRequestDto, @MappingTarget Review review);
}