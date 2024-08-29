package com.ozgur.boardapp.repository;

import com.ozgur.boardapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
