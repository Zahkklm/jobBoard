package com.banking.atmapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private String type;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
