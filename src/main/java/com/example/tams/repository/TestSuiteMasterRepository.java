package com.example.tams.repository;

import com.example.tams.model.TestSuiteMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSuiteMasterRepository extends JpaRepository<TestSuiteMaster, Long> {
}
