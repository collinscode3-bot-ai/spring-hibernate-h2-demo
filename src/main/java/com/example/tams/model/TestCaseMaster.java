package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testCaseId;
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
    private ContractMaster triggerPayloadContract;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestSuiteTestCaseMapping> suiteMappings;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseVerificationContractsMapping> verificationContractMappings;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseVerificationsContractsMapping> verificationsContractMappings;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseVerificationsMaster> verifications;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestDataMaster> testData;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedDataMaster> expectedData;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResults> runResults;
}
