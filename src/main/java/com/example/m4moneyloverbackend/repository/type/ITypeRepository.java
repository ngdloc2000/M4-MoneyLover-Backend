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
    @Query(value = "select t.* from type t join catetype c on t.id = c.type_id join category c2 on c2.id = c.category_id where c2.id = :id",nativeQuery = true)
    Iterable<Type> findAllTypeByCategory(@Param("id") Long categoryId);
}
