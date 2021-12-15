package com.example.m4moneyloverbackend.repository.type;

import com.example.m4moneyloverbackend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends PagingAndSortingRepository<Type, Long> {
}
