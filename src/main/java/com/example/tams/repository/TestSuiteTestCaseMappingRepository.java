package com.example.tams.repository;

import com.example.tams.model.TestSuiteTestCaseMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSuiteTestCaseMappingRepository extends JpaRepository<TestSuiteTestCaseMapping, Long> {
}
