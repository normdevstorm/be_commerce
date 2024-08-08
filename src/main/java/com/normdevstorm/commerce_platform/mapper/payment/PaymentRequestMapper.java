package com.normdevstorm.commerce_platform.mapper.payment;

import com.normdevstorm.commerce_platform.dto.payment.PaymentRequestDto;
import com.normdevstorm.commerce_platform.entity.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentRequestMapper {
    Payment toEntity(PaymentRequestDto paymentRequestDto);

    PaymentRequestDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentRequestDto paymentRequestDto, @MappingTarget Payment payment);
}