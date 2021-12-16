package com.example.m4moneyloverbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(targetEntity = Transaction.class, mappedBy = "category")
//    @JsonBackReference
    @JsonIgnore
    private List<Transaction> transactionList;

    @OneToMany(mappedBy = "category", targetEntity = CateType.class)
//    @JsonBackReference
    @JsonIgnore
    private List<CateType> cateTypes;
    
}
