package com.example.tams.repository;

import com.example.tams.model.TestCaseVerificationContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseVerificationContractRepository extends JpaRepository<TestCaseVerificationContract, String> {
}
