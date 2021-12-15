package com.example.m4moneyloverbackend.service;
import java.util.Optional;

public interface IGeneralService<T> {
    T save(T t);

    void remove(Long id);

    Iterable<T> findAll();

    Optional<T> findById(Long id);
}
