package com.example.m4moneyloverbackend.repository.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction ,Long> {
    @Query(value = "select t.* from transaction t join wallet w on t.wallet_id = w.id where w.id = :id",nativeQuery = true)
    Iterable<Transaction> findAllByWallet(@Param("id") Long walletId);
}
