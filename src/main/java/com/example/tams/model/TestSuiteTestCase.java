package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_suite_test_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestSuiteTestCase {
    @Id
    private String mappingId;

    @ManyToOne
    @JoinColumn(name = "test_suite_id")
    private TestSuite testSuite;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    private Integer sequenceNo;
}
