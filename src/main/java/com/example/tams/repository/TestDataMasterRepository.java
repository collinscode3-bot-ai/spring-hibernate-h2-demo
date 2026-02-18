package com.example.tams.repository;

import com.example.tams.model.TestDataMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDataMasterRepository extends JpaRepository<TestDataMaster, Long> {
}
