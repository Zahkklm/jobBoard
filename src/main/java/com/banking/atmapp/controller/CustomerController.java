package com.banking.atmapp.controller;

import com.banking.atmapp.payload.TransactionDto;
import com.banking.atmapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/deposit")
    public void deposit(@RequestParam Long customerId, @RequestParam double amount) {
        customerService.deposit(customerId, amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam Long customerId, @RequestParam double amount) {
        customerService.withdraw(customerId, amount);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam Long fromCustomerId, @RequestParam Long toCustomerId, @RequestParam double amount) {
        customerService.transfer(fromCustomerId, toCustomerId, amount);
    }

    @GetMapping("/transactions/{customerId}")
    public List<TransactionDto> getTransactions(@PathVariable Long customerId) {
        return customerService.getTransactions(customerId);
    }
}
