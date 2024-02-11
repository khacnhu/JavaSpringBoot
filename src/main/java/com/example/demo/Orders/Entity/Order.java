package com.example.demo.Orders.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "total")
    private double total;

}
