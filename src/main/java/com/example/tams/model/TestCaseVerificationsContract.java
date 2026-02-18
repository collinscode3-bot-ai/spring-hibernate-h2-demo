package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_case_verifications_contracts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseVerificationsContract {
    @Id
    private String mappingId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
