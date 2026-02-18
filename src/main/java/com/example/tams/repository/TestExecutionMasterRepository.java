package com.example.tams.repository;

import com.example.tams.model.TestExecutionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestExecutionMasterRepository extends JpaRepository<TestExecutionMaster, Long> {
}
