package com.example.m4moneyloverbackend.service.user;

import com.example.m4moneyloverbackend.model.User;
import com.example.m4moneyloverbackend.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
