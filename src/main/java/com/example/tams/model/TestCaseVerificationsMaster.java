package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseVerificationsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCaseMaster testCase;

    private String appName;
    private String serviceName;
    private String baseUrl;
    private String params;
    private Integer sequenceNo;
    private String outputFormat;
    private String verifyOnlyIfPrevSuccess; // Y/N
    private String keyTypeIsComposite; // Y/N
    private String compositeKeyDelimiter;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<VerificationParameterMaster> parameters;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ValidationsMaster> validations;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedDataMaster> expectedData;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResults> runResults;
}
