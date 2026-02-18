package com.example.tams.repository;

import com.example.tams.model.TestCaseVerificationsContractsMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseVerificationsContractsMappingRepository extends JpaRepository<TestCaseVerificationsContractsMapping, Long> {
}
