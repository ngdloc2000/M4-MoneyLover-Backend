package com.example.m4moneyloverbackend;

import com.example.m4moneyloverbackend.model.User;
import com.example.m4moneyloverbackend.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class M4MoneyLoverBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(M4MoneyLoverBackendApplication.class, args);
    }

        @Bean
        CommandLineRunner run(UserService userService) {
        return args -> {
            userService.save(new User(null, "lộc", null, "0123456789", null, "loc", "1", new ArrayList<>()));
        };
    }
}
