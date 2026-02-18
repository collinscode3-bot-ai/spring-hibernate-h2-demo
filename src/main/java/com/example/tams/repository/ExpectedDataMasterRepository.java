package com.example.tams.repository;

import com.example.tams.model.ExpectedDataMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpectedDataMasterRepository extends JpaRepository<ExpectedDataMaster, Long> {
}
