package com.example.tams.repository;

import com.example.tams.model.ProjectTestSuiteMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTestSuiteMappingRepository extends JpaRepository<ProjectTestSuiteMapping, Long> {
}
