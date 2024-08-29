package com.ozgur.cvapp.repository;

import com.ozgur.cvapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
