package com.example.tams.repository;

import com.example.tams.model.ContractFieldProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractFieldPropertiesRepository extends JpaRepository<ContractFieldProperties, Long> {
}
