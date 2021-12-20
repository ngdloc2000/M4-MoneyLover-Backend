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
<<<<<<< HEAD

    List<SumAmountEachDayInMonth> sumAmountEachDayInMonth(Long cateId, Long walletId, String month);
=======
    Double findAllTransactionAndSumAmountByDate(Date date,Long id);
    Double findAllSumAmountByCategoryId(Long id);

>>>>>>> 0de41ce3a79290cf179d0e6215b49197ff5e543c
}
