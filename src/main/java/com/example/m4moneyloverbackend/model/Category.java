package com.example.m4moneyloverbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String icon;

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "category")
    @JsonBackReference
    private List<Transaction> transactionList;
    @OneToMany(mappedBy = "category", targetEntity = CateType.class,fetch = FetchType.LAZY)
    private List<CateType> cateTypes;
    
}
