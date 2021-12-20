package com.example.m4moneyloverbackend.controller;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.model.Wallet;
import com.example.m4moneyloverbackend.service.transaction.ITransactionService;
import com.example.m4moneyloverbackend.service.wallet.IWalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private Environment env;
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private IWalletService walletService;

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.findById(id);
        if (!transaction.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Transaction> saveTransaction(@RequestPart("file") MultipartFile file, @RequestPart("newTransaction") String transaction) {
        String file1 = file.getOriginalFilename();
        try {
            Transaction transaction1 = new ObjectMapper().readValue(transaction, Transaction.class);
            transaction1.setFile(file1);
            transactionService.save(transaction1);
            return new ResponseEntity<>(transaction1, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String fileUpload = env.getProperty("upload.path");
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + file1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Transaction>> showAll() {
        return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.save(transaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> removeTransaction(@PathVariable Long id) {
        transactionService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showAllTransByWalletId/{id}")
    public ResponseEntity<Iterable<Transaction>> findAllTransactionByWallet(@PathVariable Long id) {
        Optional<Wallet> wallet = walletService.findByUserId(id);
        List<Transaction> transactions = (List<Transaction>) transactionService.findAllByWallet(wallet.get().getId());
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<Transaction>> findAll(@PageableDefault(value = 7) Pageable pageable) {
        return new ResponseEntity<>(transactionService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/findDate/{dateTime}")
    public ResponseEntity<Iterable<Transaction>> findAllByDate(@PathVariable Date dateTime) {
        return new ResponseEntity<>(transactionService.findAllByDate(dateTime), HttpStatus.OK);
    }

    @GetMapping("/sumAmountByExpense/{walletId}")
    public ResponseEntity<Double> sumAmountByExpense(@PathVariable Long walletId) {
        return new ResponseEntity<>(transactionService.sumAmountByCategory(walletId, 1L), HttpStatus.OK);
    }

    @GetMapping("/sumAmountByIncome/{walletId}")
    public ResponseEntity<Double> sumAmountByIncome(@PathVariable Long walletId) {
        return new ResponseEntity<>(transactionService.sumAmountByCategory(walletId, 3L), HttpStatus.OK);
    }
}
