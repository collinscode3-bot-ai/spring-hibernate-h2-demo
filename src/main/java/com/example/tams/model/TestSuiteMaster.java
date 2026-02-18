package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestSuiteMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testSuiteId;
    private String suiteName;
    private String suiteDesc;
    private String type; // E2E_TEST, INT_TEST, etc.

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ProjectTestSuiteMapping> projectMappings;

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestSuiteTestCaseMapping> testCaseMappings;

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestExecutionMaster> executions;
}
