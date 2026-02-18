package com.example.tams.repository;

import com.example.tams.model.ValidationParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationParameterRepository extends JpaRepository<ValidationParameter, String> {
}
