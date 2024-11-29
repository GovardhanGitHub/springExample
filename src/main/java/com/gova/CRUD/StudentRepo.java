package com.gova.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    // JpaRepository provides basic CRUD operations
    // We can add custom query methods if needed
    Student findByEmail(String email);
}