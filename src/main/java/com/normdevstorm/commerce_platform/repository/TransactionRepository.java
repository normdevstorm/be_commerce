package com.normdevstorm.commerce_platform.repository;

import com.normdevstorm.commerce_platform.entity.Transaction;
import com.normdevstorm.commerce_platform.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    @Transactional
    @Modifying
    @Query("update Transaction t set t.status = ?1 where t.transactionId = ?2")
    int updateTransaction(@NonNull Status status, @NonNull UUID transactionId);

    @Query("select t from Transaction t where t.createAt < ?1 and t.user.userId = ?2")
    Set<Transaction> findByCreateAtBefore(@NonNull LocalDateTime createAt, @NonNull UUID userId);

    Set<Transaction> findByUser_UserId(@NonNull UUID userId);
}