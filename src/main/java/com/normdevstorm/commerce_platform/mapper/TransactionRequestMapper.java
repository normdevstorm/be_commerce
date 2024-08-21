package com.normdevstorm.commerce_platform.mapper;

import com.normdevstorm.commerce_platform.dto.transaction.TransactionRequestDto;
import com.normdevstorm.commerce_platform.dto.transaction.TransactionResponseDto;
import com.normdevstorm.commerce_platform.entity.Transaction;
import com.normdevstorm.commerce_platform.entity.User;
import org.mapstruct.*;
import org.springframework.context.annotation.Bean;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionRequestMapper {
    @Mapping(target = "user", source = "user")
    public Transaction toTransaction(TransactionRequestDto transactionRequestDto, User user);
    public TransactionRequestDto toDto(Transaction transaction);
}
