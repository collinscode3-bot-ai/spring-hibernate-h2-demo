package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "expected_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpectedData {
    @Id
    private String expectedDataId;

    @ManyToOne
    @JoinColumn(name = "test_data_id")
    private TestData testData;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerification verification;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private Validation validation;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @Lob
    private String expectedData;
}
