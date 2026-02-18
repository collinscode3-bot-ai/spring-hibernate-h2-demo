package com.example.tams.repository;

import com.example.tams.model.ExpectedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpectedDataRepository extends JpaRepository<ExpectedData, String> {
}
