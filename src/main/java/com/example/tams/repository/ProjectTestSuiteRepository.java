package com.example.tams.repository;

import com.example.tams.model.ProjectTestSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTestSuiteRepository extends JpaRepository<ProjectTestSuite, String> {
}
