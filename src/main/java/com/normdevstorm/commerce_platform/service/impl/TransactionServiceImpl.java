package com.normdevstorm.commerce_platform.service.impl;

import com.normdevstorm.commerce_platform.dto.transaction.TransactionRequestDto;
import com.normdevstorm.commerce_platform.dto.transaction.TransactionResponseDto;
import com.normdevstorm.commerce_platform.entity.Transaction;
import com.normdevstorm.commerce_platform.entity.User;
import com.normdevstorm.commerce_platform.enums.Status;
import com.normdevstorm.commerce_platform.mapper.TransactionRequestMapper;
import com.normdevstorm.commerce_platform.mapper.transaction.TransactionResponseMapper;
import com.normdevstorm.commerce_platform.repository.TransactionRepository;
import com.normdevstorm.commerce_platform.service.JwtService;
import com.normdevstorm.commerce_platform.service.TransactionService;
import com.normdevstorm.commerce_platform.util.UtilsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

///todo: handle exceptions
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository  transactionRepository;
    private final TransactionResponseMapper transactionResponseMapper;
    private final TransactionRequestMapper transactionRequestMapper;
    private final JwtService jwtService;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionResponseMapper transactionResponseMapper, TransactionRequestMapper transactionRequestMapper, JwtService jwtService) {
        this.transactionRepository = transactionRepository;
        this.transactionResponseMapper = transactionResponseMapper;
        this.transactionRequestMapper = transactionRequestMapper;
        this.jwtService = jwtService;
    }
    @Override
    public TransactionResponseDto createTransaction(TransactionRequestDto transactionRequestDto) {
        ///todo: replace with this method in other services as well
        try {
            User user = jwtService.claimUserFromToken();
            Transaction newTransaction = transactionRequestMapper.toTransaction(transactionRequestDto, user);
            return transactionResponseMapper.toDto(transactionRepository.save(newTransaction));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TransactionResponseDto updateTransaction(String transactionid, Status transactionStatus) {
        try {
            boolean  isSuccess = UtilsManager.toBoolean(transactionRepository.updateTransaction(transactionStatus, UUID.fromString(transactionid)));
            if (isSuccess) {
                return transactionResponseMapper.toDto(transactionRepository.findById(UUID.fromString(transactionid)).get());
            } else {
                throw new RuntimeException("Transaction update failed");
            }
        } catch (RuntimeException e) {
            log.error("Transaction update failed", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<TransactionResponseDto> getAllTransactions() {
        try {
            User user = jwtService.claimUserFromToken();
            return transactionRepository.findByUser_UserId(user.getUserId()).stream().map(transactionResponseMapper::toDto).collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("Get all transactions error:", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<TransactionResponseDto> getAllTransactionsBeforeTime(LocalDateTime time) {
        try {
            User user = jwtService.claimUserFromToken();
            Set<Transaction> transactions = transactionRepository.findByCreateAtBefore(time, user.getUserId());
            return  transactions.stream().map(transactionResponseMapper::toDto).collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("Get transaction error:", e);
            throw new RuntimeException(e);
        }
    }

}
