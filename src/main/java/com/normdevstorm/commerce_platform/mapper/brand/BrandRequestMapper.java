package com.normdevstorm.commerce_platform.mapper.brand;

import com.normdevstorm.commerce_platform.dto.brand.BrandRequestDto;
import com.normdevstorm.commerce_platform.entity.Brand;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandRequestMapper {
    Brand toEntity(BrandRequestDto brandRequestDto);

    BrandRequestDto toDto(Brand brand);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Brand partialUpdate(BrandRequestDto brandRequestDto, @MappingTarget Brand brand);
}