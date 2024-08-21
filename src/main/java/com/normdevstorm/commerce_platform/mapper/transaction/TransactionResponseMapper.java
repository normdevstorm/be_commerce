package com.normdevstorm.commerce_platform.mapper.transaction;

import com.normdevstorm.commerce_platform.dto.transaction.TransactionResponseDto;
import com.normdevstorm.commerce_platform.entity.Transaction;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionResponseMapper {
//    Transaction toEntity(TransactionResponseDto transactionResponseDto);
    @Mapping(target = "userId", source = "transaction.user.userId")
    TransactionResponseDto toDto(Transaction transaction);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Transaction partialUpdate(TransactionResponseDto transactionResponseDto, @MappingTarget Transaction transaction);
}