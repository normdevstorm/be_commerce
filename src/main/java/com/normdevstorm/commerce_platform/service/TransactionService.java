package com.normdevstorm.commerce_platform.service;

import com.normdevstorm.commerce_platform.dto.transaction.TransactionRequestDto;
import com.normdevstorm.commerce_platform.dto.transaction.TransactionResponseDto;
import com.normdevstorm.commerce_platform.enums.Status;

import java.time.LocalDateTime;
import java.util.Set;

public interface TransactionService {
    TransactionResponseDto createTransaction(TransactionRequestDto transactionRequestDto);

    TransactionResponseDto updateTransaction(String transactionid, Status transactionStatus);

    Set<TransactionResponseDto> getAllTransactions();

    Set<TransactionResponseDto> getAllTransactionsBeforeTime(LocalDateTime time);
}
