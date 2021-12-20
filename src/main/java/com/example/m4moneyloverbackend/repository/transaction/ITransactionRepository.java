package com.example.m4moneyloverbackend.repository.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Map;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction ,Long> {
    @Query(value = "select t.* from transaction t join wallet w on t.wallet_id = w.id where w.id = :id",nativeQuery = true)
    Iterable<Transaction> findAllByWallet(@Param("id") Long walletId);

    Iterable<Transaction> findAllByDate(Date date);

    @Query(value = "select sum(amount) from transaction t join transactiondetail t2 on t.id = t2.transaction_id join type t3 on t3.id = t2.type_id join category c on c.id = t3.category_id where t.wallet_id = :wallet and c.id = :cate", nativeQuery = true)
    Double sumAmountByCategory(@Param("wallet") Long walletId, @Param("cate") Long cateId);

    @Query(value = "select sum(amount) from transaction t join transactiondetail t2 on t.id = t2.transaction_id join type t3 on t3.id = t2.type_id join category c on c.id = t3.category_id where t.date = :date and c.id=:id", nativeQuery = true)
         Double findAllTransactionAndSumAmountByDate(@Param("date") Date date,@Param("id")Long id);

    @Query(value = "select sum(amount) from transaction t join transactiondetail t2 on t.id = t2.transaction_id join type t3 on t3.id = t2.type_id join category c on c.id = t3.category_id where c.id = :id",nativeQuery = true)
        Double findAllSumAmountByCategoryId(@Param("id") Long id);
}
