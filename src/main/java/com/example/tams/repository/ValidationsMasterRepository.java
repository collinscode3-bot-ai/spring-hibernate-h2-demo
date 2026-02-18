package com.example.tams.repository;

import com.example.tams.model.ValidationsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationsMasterRepository extends JpaRepository<ValidationsMaster, Long> {
}
