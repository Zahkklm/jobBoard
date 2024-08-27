package com.banking.atmapp.repository;

import java.util.Optional;

import com.banking.atmapp.model.ERole;
import com.banking.atmapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
