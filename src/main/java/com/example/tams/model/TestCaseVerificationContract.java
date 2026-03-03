package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_case_verification_contracts")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseVerificationContract extends BaseAuditEntity {
    @Id
    private String mappingId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
