package com.example.m4moneyloverbackend.repository.wallet;

import com.example.m4moneyloverbackend.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findByUserId(Long id);
}
