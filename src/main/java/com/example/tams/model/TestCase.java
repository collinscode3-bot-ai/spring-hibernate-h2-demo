package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "test_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {
    @Id
    private String testCaseId;
    private String testName;
    private String testDescription;
    private String action;
    private String triggerUrl;
    private String appName;
    private String serviceName;
    private String inputPayloadFormat;
    private String executeIfPrevSuccess;

    @ManyToOne
    @JoinColumn(name = "trigger_payload_contract_id")
    private Contract triggerPayloadContract;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestSuiteTestCase> suiteMappings;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseVerificationContract> verificationContractMappings;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseVerificationsContract> verificationsContractMappings;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseVerification> verifications;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestData> testData;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedData> expectedData;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResult> runResults;
}
