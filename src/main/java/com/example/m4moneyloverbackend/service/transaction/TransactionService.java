package com.example.m4moneyloverbackend.service.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.repository.transaction.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public Double findAllSumAmountByCategoryId(Long id) {
        return transactionRepository.findAllSumAmountByCategoryId(id);
    }

    @Override
    public Double findAllTransactionAndSumAmountByDate(Date date,Long id) {
        return transactionRepository.findAllTransactionAndSumAmountByDate(date,id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Iterable<Transaction> findAllByWallet(Long walletId) {
        return transactionRepository.findAllByWallet(walletId);
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Iterable<Transaction> findAllByDate(Date date) {
        return transactionRepository.findAllByDate(date);
    }

    @Override
    public Double sumAmountByCategory(Long walletId, Long categoryId) {
        return transactionRepository.sumAmountByCategory(walletId, categoryId);
    }
}
