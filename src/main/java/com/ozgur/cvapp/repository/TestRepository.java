package com.ozgur.cvapp.repository;

import com.ozgur.cvapp.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findById(Long id);
}
