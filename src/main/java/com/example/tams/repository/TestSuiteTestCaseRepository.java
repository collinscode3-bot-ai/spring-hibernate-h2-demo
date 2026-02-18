package com.example.tams.repository;

import com.example.tams.model.TestSuiteTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSuiteTestCaseRepository extends JpaRepository<TestSuiteTestCase, String> {
}
