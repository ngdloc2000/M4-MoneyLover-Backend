package com.example.m4moneyloverbackend.repository.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction ,Long> {
}
