package com.example.m4moneyloverbackend.service.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ITransactionService extends IGeneralService <Transaction>{
    Iterable<Transaction> findAllByWallet(Long walletId);
    Page<Transaction> findAll(Pageable pageable);
    Iterable<Transaction> findAllByDate(Date date);
    Double sumAmountByCategory(Long walletId, Long categoryId);
}
