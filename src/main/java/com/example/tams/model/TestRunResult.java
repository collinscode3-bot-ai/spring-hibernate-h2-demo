package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_run_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestRunResult {
    @Id
    private String runId;

    @ManyToOne
    @JoinColumn(name = "execution_id")
    private TestExecution execution;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerification verification;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private Validation validation;

    private String testResult;
    private String status;

    @Lob
    private String errorMessage;
}
