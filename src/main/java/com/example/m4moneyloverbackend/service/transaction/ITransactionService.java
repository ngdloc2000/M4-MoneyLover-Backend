package com.example.m4moneyloverbackend.service.transaction;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.model.dto.SumAmountEachDayInMonth;
import com.example.m4moneyloverbackend.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface ITransactionService extends IGeneralService<Transaction> {
    Iterable<Transaction> findAllByWallet(Long walletId);

    Page<Transaction> findAll(Pageable pageable);

    Iterable<Transaction> findAllByDate(Date date);

    Double sumAmountByCategory(Long walletId, Long categoryId);


    List<SumAmountEachDayInMonth> sumAmountEachDayInMonth(Long cateId, Long walletId, String month);

    Double findAllTransactionAndSumAmountByDate(Date date,Long id);
    Double findAllSumAmountByCategoryId(Long id);

}
