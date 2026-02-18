package com.example.tams.repository;

import com.example.tams.model.TestCaseVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseVerificationRepository extends JpaRepository<TestCaseVerification, String> {
}
