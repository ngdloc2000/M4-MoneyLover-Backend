package com.example.m4moneyloverbackend.controller;


import com.example.m4moneyloverbackend.model.Type;
import com.example.m4moneyloverbackend.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping("")
    public ResponseEntity<Iterable<Type>> findAll() {
        return new ResponseEntity<>(typeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> findById(@PathVariable Long id) {
        Optional<Type> typeOptional = typeService.findById(id);
        return typeOptional.map(type -> new ResponseEntity<>(type, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Type> addNewType(@RequestBody Type type) {
        return new ResponseEntity<>(typeService.save(type), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Type> updateType(@RequestBody Type type) {
        return new ResponseEntity<>(typeService.save(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Type> deleteType(@PathVariable Long id) {
        typeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
