package com.banking.atmapp.controller;

import com.banking.atmapp.payload.CustomerDto;
import com.banking.atmapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return adminService.getCustomerById(id);
    }
}
