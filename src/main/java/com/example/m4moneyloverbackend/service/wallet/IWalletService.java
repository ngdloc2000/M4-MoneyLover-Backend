package com.example.m4moneyloverbackend.service.wallet;

import com.example.m4moneyloverbackend.model.Wallet;
import com.example.m4moneyloverbackend.service.IGeneralService;

import java.util.Optional;

public interface IWalletService extends IGeneralService<Wallet> {
    Optional<Wallet> findByUserId(Long id);
}
