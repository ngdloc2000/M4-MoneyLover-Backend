package com.example.m4moneyloverbackend.controller;

import com.example.m4moneyloverbackend.model.TransactionDetail;
import com.example.m4moneyloverbackend.service.transactionDetail.ITransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/transactionDetails")
public class TransactionDetailController {
    @Autowired
    private ITransactionDetailService transactionDetailService;

    @GetMapping("")
    public ResponseEntity<Iterable<TransactionDetail>> findAll() {
        return new ResponseEntity<>(transactionDetailService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDetail> findById(@PathVariable Long id) {
        Optional<TransactionDetail> transactionDetailOptional = transactionDetailService.findById(id);
        return transactionDetailOptional.map(transactionDetail -> new ResponseEntity<>(transactionDetail, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TransactionDetail> addNewTransactionDetail(@RequestBody TransactionDetail transactionDetail) {
        return new ResponseEntity<>(transactionDetailService.save(transactionDetail), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TransactionDetail> updateTransactionDetail(@RequestBody TransactionDetail transactionDetail) {
        return new ResponseEntity<>(transactionDetailService.save(transactionDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionDetail> deleteTransactionDetail(@PathVariable Long id) {
        transactionDetailService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
