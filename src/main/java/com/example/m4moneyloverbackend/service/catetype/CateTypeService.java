package com.example.m4moneyloverbackend.service.catetype;

import com.example.m4moneyloverbackend.model.CateType;
import com.example.m4moneyloverbackend.repository.catetype.ICatetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CateTypeService implements ICatetypeService {

    @Autowired
    private ICatetypeRepository catetypeRepository;

    @Override
    public CateType save(CateType cateType) {
        return catetypeRepository.save(cateType);
    }

    @Override
    public void remove(Long id) {
        catetypeRepository.deleteById(id);
    }

    @Override
    public Iterable<CateType> findAll() {
        return catetypeRepository.findAll();
    }

    @Override
    public Optional<CateType> findById(Long id) {
        return catetypeRepository.findById(id);
    }
}