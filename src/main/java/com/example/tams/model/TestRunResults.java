package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestRunResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long runId;

    @ManyToOne
    @JoinColumn(name = "execution_id")
    private TestExecutionMaster execution;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCaseMaster testCase;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerificationsMaster verification;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private ValidationsMaster validation;

    private String testResult;
    private String status;

    @Lob
    private String errorMessage;
}
