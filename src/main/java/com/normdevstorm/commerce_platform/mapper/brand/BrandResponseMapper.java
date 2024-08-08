package com.normdevstorm.commerce_platform.mapper.brand;

import com.normdevstorm.commerce_platform.dto.brand.BrandResposeDto;
import com.normdevstorm.commerce_platform.entity.Brand;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandResponseMapper {
    Brand toEntity(BrandResposeDto brandResposeDto);

    @AfterMapping
    default void linkProducts(@MappingTarget Brand brand) {
        brand.getProducts().forEach(product -> product.setBrand(brand));
    }

    BrandResposeDto toDto(Brand brand);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Brand partialUpdate(BrandResposeDto brandResposeDto, @MappingTarget Brand brand);
}

///todo: use 'expression' to fetch all the unrevealed data
//@Mapper(componentModel = "spring")
//public interface AMapper {
//    @Mapping(target = "description", constant = "default value or from another source")
//    A toEntity(ADTO dto);
//}
