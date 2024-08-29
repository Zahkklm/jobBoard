package com.ozgur.boardapp.repository;

import com.ozgur.boardapp.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findById(Long id);
}
