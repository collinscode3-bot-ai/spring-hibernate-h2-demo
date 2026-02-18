package com.example.tams.repository;

import com.example.tams.model.ContractFieldProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractFieldPropertyRepository extends JpaRepository<ContractFieldProperty, String> {
}
