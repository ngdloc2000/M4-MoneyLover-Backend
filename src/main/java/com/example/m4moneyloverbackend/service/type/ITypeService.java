package com.example.m4moneyloverbackend.service.type;

import com.example.m4moneyloverbackend.model.Type;
import com.example.m4moneyloverbackend.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface ITypeService extends IGeneralService<Type> {
    Iterable<Type> findAllTypeByCategory(Long categoryId);
}
