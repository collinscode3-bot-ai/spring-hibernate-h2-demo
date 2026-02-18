package com.example.tams.repository;

import com.example.tams.model.TestRunResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRunResultRepository extends JpaRepository<TestRunResult, String> {
}
