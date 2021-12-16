package com.example.m4moneyloverbackend.controller;


import com.example.m4moneyloverbackend.model.CateType;
import com.example.m4moneyloverbackend.service.catetype.ICatetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cateType")
public class CateTypeController {

    @Autowired
    private ICatetypeService cateTypeService;

    @GetMapping("")
    public ResponseEntity<Iterable<CateType>> findAll() {
        return new ResponseEntity<>(cateTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CateType> findById(@PathVariable Long id) {
        Optional<CateType> cateTypeOptional = cateTypeService.findById(id);
        return cateTypeOptional.map(type -> new ResponseEntity<>(type, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CateType> addNewType(@RequestBody CateType cateType) {
        return new ResponseEntity<>(cateTypeService.save(cateType), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CateType> updateType(@RequestBody CateType cateType) {
        return new ResponseEntity<>(cateTypeService.save(cateType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CateType> deleteType(@PathVariable Long id) {
        cateTypeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
