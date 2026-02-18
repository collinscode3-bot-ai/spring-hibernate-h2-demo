package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "test_case_verifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseVerification {
    @Id
    private String verificationId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

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
    private List<VerificationParameter> parameters;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Validation> validations;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedData> expectedData;

    @OneToMany(mappedBy = "verification", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResult> runResults;
}
