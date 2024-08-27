package com.banking.atmapp.service;

import com.banking.atmapp.repository.CustomerRepository;
import com.banking.atmapp.repository.TransactionRepository;
import com.banking.atmapp.payload.TransactionDto;
import com.banking.atmapp.model.Customer;
import com.banking.atmapp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void deposit(Long customerId, double amount) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.setBalance(customer.getBalance() + amount);
        customerRepository.save(customer);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType("DEPOSIT");
        transaction.setCustomer(customer);
        transactionRepository.save(transaction);
    }

    public void withdraw(Long customerId, double amount) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        if (customer.getBalance() >= amount) {
            customer.setBalance(customer.getBalance() - amount);
            customerRepository.save(customer);
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setType("WITHDRAW");
            transaction.setCustomer(customer);
            transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

    public void transfer(Long fromCustomerId, Long toCustomerId, double amount) {
        Customer fromCustomer = customerRepository.findById(fromCustomerId).orElseThrow();
        Customer toCustomer = customerRepository.findById(toCustomerId).orElseThrow();
        if (fromCustomer.getBalance() >= amount) {
            fromCustomer.setBalance(fromCustomer.getBalance() - amount);
            toCustomer.setBalance(toCustomer.getBalance() + amount);
            customerRepository.save(fromCustomer);
            customerRepository.save(toCustomer);
            Transaction fromTransaction = new Transaction();
            fromTransaction.setAmount(amount);
            fromTransaction.setType("TRANSFER_OUT");
            fromTransaction.setCustomer(fromCustomer);
            transactionRepository.save(fromTransaction);
            Transaction toTransaction = new Transaction();
            toTransaction.setAmount(amount);
            toTransaction.setType("TRANSFER_IN");
            toTransaction.setCustomer(toCustomer);
            transactionRepository.save(toTransaction);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

    public List<TransactionDto> getTransactions(Long customerId) {
        return transactionRepository.findByCustomerId(customerId).stream()
                .map(transaction -> new TransactionDto(transaction.getId(), transaction.getCustomer().getId(), transaction.getAmount(), transaction.getType(), transaction.getTimestamp()))
                .collect(Collectors.toList());
    }
}
