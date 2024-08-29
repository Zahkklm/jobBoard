package com.ozgur.cvapp.controller;

import com.ozgur.cvapp.model.User;
import com.ozgur.cvapp.payload.request.SignupRequest;
import com.ozgur.cvapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/customers")
    public List<User> getAllUser() {
        return adminService.getAllUsers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/customers/{id}")
    public User getUser(@PathVariable Long id) {
        return adminService.getUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/customers")
    public void addUser(@RequestBody SignupRequest signupRequest) {
        adminService.addUser(signupRequest);
    }

}
