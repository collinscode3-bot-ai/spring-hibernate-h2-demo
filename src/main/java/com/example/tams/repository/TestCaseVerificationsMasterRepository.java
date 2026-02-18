package com.example.tams.repository;

import com.example.tams.model.TestCaseVerificationsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseVerificationsMasterRepository extends JpaRepository<TestCaseVerificationsMaster, Long> {
}
