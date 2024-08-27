package com.banking.atmapp.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String username;
    private double balance;
}
