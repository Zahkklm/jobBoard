package com.banking.atmapp.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private Long customerId;
    private double amount;
    private String type;
    private LocalDateTime timestamp;
}

