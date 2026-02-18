package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "test_suites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestSuite {
    @Id
    private String testSuiteId;
    private String suiteName;
    private String suiteDesc;
    private String type; // E2E_TEST, INT_TEST, etc.

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ProjectTestSuite> projectMappings;

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestSuiteTestCase> testCaseMappings;

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestExecution> executions;
}
