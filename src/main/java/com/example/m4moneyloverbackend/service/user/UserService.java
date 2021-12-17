package com.example.m4moneyloverbackend.service.user;

import com.example.m4moneyloverbackend.model.User;
import com.example.m4moneyloverbackend.model.UserPrinciple;
import com.example.m4moneyloverbackend.model.Wallet;
import com.example.m4moneyloverbackend.repository.user.IUserRepository;
import com.example.m4moneyloverbackend.service.wallet.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IWalletService walletService;

    @Override
    public User save(User user) {
        Wallet wallet = new Wallet();
        wallet.setBalance(0.0);
        wallet.setName("Ví của " + user.getName());
        User newUser = userRepository.save(user);
        wallet.setUser(newUser);
        walletService.save(wallet);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return newUser;
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }
}
