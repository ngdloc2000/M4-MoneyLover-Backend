package com.example.m4moneyloverbackend.service.wallet;

import com.example.m4moneyloverbackend.model.Wallet;
import com.example.m4moneyloverbackend.repository.wallet.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class WalletService implements IWalletService{
    @Autowired
    private IWalletRepository walletRepository;
    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void remove(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public Iterable<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    @Override
    public Optional<Wallet> findByUserId(Long id) {
        return walletRepository.findByUserId(id);
    }
}
