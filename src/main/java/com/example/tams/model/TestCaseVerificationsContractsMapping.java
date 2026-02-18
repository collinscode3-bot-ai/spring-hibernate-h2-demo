package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseVerificationsContractsMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCaseMaster testCase;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractMaster contract;
}
