package com.example.m4moneyloverbackend.repository.catetype;


import com.example.m4moneyloverbackend.model.CateType;
import com.example.m4moneyloverbackend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatetypeRepository extends JpaRepository<CateType, Long> {
}
