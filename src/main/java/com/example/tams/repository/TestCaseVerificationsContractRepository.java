package com.example.tams.repository;

import com.example.tams.model.TestCaseVerificationsContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseVerificationsContractRepository extends JpaRepository<TestCaseVerificationsContract, String> {
}
