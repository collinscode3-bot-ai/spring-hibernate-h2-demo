package com.example.tams.repository;

import com.example.tams.model.TestCaseVerificationContractsMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseVerificationContractsMappingRepository extends JpaRepository<TestCaseVerificationContractsMapping, Long> {
}
