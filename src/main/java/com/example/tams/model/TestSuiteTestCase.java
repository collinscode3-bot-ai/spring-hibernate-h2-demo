package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_suite_test_cases")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestSuiteTestCase extends BaseAuditEntity {
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
