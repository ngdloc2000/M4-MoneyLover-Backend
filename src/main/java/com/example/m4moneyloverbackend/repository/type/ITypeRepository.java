package com.example.m4moneyloverbackend.repository.type;

import com.example.m4moneyloverbackend.model.Transaction;
import com.example.m4moneyloverbackend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Long> {
    Iterable<Type> findAllByCategory_Id(Long cateId);
}
