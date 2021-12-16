package com.example.m4moneyloverbackend.controller;

import com.example.m4moneyloverbackend.model.Wallet;
import com.example.m4moneyloverbackend.service.wallet.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin("*")
@Controller
@RequestMapping("/wallets")
public class WalletController {
    @Autowired
    private IWalletService walletService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<Wallet>>listWallet(){
        return new ResponseEntity<>(walletService.findAll(), HttpStatus.OK);
    }
}




