package com.ozgur.boardapp.repository;

import java.util.Optional;

import com.ozgur.boardapp.model.enums.ERole;
import com.ozgur.boardapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
