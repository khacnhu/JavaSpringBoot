package com.example.demo.Transaction;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bank")
@Data
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "balance")
    private Integer balance;

}
