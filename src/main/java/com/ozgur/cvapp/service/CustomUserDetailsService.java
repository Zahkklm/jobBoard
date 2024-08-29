package com.ozgur.cvapp.service;

import com.ozgur.cvapp.repository.AdminRepository;
import com.ozgur.cvapp.repository.EmployeeRepository;
import com.ozgur.cvapp.model.Admin;
import com.ozgur.cvapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return org.springframework.security.core.userdetails.User.withUsername(admin.getUsername())
                    .roles("ADMIN")
                    .build();
        }

        User user = employeeRepository.findByUsername(username);
        if (user != null) {
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}

