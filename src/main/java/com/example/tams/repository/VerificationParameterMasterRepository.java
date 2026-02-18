package com.example.tams.repository;

import com.example.tams.model.VerificationParameterMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationParameterMasterRepository extends JpaRepository<VerificationParameterMaster, Long> {
}
