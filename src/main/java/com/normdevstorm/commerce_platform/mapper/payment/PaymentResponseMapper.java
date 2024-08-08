package com.normdevstorm.commerce_platform.mapper.payment;

import com.normdevstorm.commerce_platform.dto.payment.PaymentResponseDto;
import com.normdevstorm.commerce_platform.entity.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentResponseMapper {
    Payment toEntity(PaymentResponseDto paymentResponseDto);

    PaymentResponseDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentResponseDto paymentResponseDto, @MappingTarget Payment payment);
}