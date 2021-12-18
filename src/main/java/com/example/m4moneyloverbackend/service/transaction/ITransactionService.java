package com.example.m4moneyloverbackend.service.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ITransactionService extends IGeneralService <Transaction>{
    Iterable<Transaction> findAllByWallet(Long walletId);
}
