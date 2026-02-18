package com.example.tams.repository;

import com.example.tams.model.ProjectMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMasterRepository extends JpaRepository<ProjectMaster, Long> {
}
