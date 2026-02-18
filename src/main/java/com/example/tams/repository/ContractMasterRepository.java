package com.example.tams.repository;

import com.example.tams.model.ContractMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractMasterRepository extends JpaRepository<ContractMaster, Long> {
}
