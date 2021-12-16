package com.example.m4moneyloverbackend.controller;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.service.transaction.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
   private Environment environment;
    @Autowired
    private ITransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.findById(id);
        if (!transaction.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Transaction> createTransaction(@RequestPart("file")MultipartFile file,@RequestPart("newTransaction") String transaction) {
        MultipartFile multipartFile = file;
        String file1=multipartFile.getOriginalFilename();
        try {
            Transaction transaction1= new ObjectMapper().readValue(transaction,Transaction.class);
            transaction1.setFile(file1);
            transactionService.save(transaction1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String fileUpload = environment.getProperty("upload.path");
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),new File(fileUpload+file));
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
}
