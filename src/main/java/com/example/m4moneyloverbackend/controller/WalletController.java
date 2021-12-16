package com.example.m4moneyloverbackend.controller;

import com.example.m4moneyloverbackend.model.Wallet;
import com.example.m4moneyloverbackend.service.wallet.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/wallets")
public class WalletController {
    @Autowired
    private IWalletService walletService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<Wallet>>listWallet(){
        return new ResponseEntity<>(walletService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet){
        walletService.save(wallet);
        return new ResponseEntity<>(wallet,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Wallet> deleteWallet(@PathVariable Long id){
        walletService.remove(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Wallet> editWallet(@PathVariable Long id, @RequestBody Wallet wallet){
        Optional<Wallet> walletOptional = walletService.findById(id);
        if(!walletOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wallet.setId(walletOptional.get().getId());
        walletService.save(wallet);
        return new ResponseEntity<>(wallet,HttpStatus.OK);
    }
}




