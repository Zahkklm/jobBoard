package com.banking.atmapp.service;
import com.banking.atmapp.repository.CustomerRepository;
import com.banking.atmapp.payload.CustomerDto;
import com.banking.atmapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDto(customer.getId(), customer.getUsername(), customer.getBalance()))
                .collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return new CustomerDto(customer.getId(), customer.getUsername(), customer.getBalance());
    }
}
