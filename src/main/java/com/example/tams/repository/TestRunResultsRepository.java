package com.example.tams.repository;

import com.example.tams.model.TestRunResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRunResultsRepository extends JpaRepository<TestRunResults, Long> {
}
