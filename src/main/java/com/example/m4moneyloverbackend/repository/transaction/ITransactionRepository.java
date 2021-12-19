package com.example.m4moneyloverbackend.repository.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction ,Long> {
    @Query(value = "select t.* from transaction t join wallet w on t.wallet_id = w.id where w.id = :id",nativeQuery = true)
    Iterable<Transaction> findAllByWallet(@Param("id") Long walletId);

    Iterable<Transaction> findAllByDate(Date date);

    @Query(value = "select sum(amount) from transaction join transactiondetail t on transaction.id = t.transaction_id join type t2 on t2.id = t.type_id join category c on c.id = t2.category_id where c.id = :id", nativeQuery = true)
    Double sumAmountByCategory(@Param("id") Long categoryId);
}
