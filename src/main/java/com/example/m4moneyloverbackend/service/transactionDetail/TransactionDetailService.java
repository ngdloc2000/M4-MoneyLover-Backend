package com.example.m4moneyloverbackend.service.transactionDetail;

import com.example.m4moneyloverbackend.model.TransactionDetail;
import com.example.m4moneyloverbackend.repository.transactionDetail.ITransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TransactionDetailService implements ITransactionDetailService {

    @Autowired
    private ITransactionDetailRepository transactionDetailRepository;
    @Override
    public TransactionDetail save(TransactionDetail transactionDetail) {
        return transactionDetailRepository.save(transactionDetail);
    }

    @Override
    public void remove(Long id) {
        transactionDetailRepository.deleteById(id);
    }

    @Override
    public Iterable<TransactionDetail> findAll() {
        return transactionDetailRepository.findAll();
    }

    @Override
    public Optional<TransactionDetail> findById(Long id) {
        return transactionDetailRepository.findById(id);
    }
}
