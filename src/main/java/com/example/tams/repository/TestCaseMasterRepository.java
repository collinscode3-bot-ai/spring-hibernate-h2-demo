package com.example.tams.repository;

import com.example.tams.model.TestCaseMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseMasterRepository extends JpaRepository<TestCaseMaster, Long> {
}
