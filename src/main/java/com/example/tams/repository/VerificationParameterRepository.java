package com.example.tams.repository;

import com.example.tams.model.VerificationParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationParameterRepository extends JpaRepository<VerificationParameter, String> {
}
