package com.example.m4moneyloverbackend.repository.transactionDetail;

import com.example.m4moneyloverbackend.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
}
