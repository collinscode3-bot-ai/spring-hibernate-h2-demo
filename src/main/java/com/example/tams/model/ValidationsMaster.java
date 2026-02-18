package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long validationId;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerificationsMaster verification;

    private String sourceData;
    private String validationType;
    private String validationName;
    private Integer sequenceNo;
    private String expectedOutcomeValue;

    @ManyToOne
    @JoinColumn(name = "payload_contract_id")
    private ContractMaster payloadContract;

    private String payloadFormat;

    @Lob
    private String errorMessages;

    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ValidationParameterMaster> parameters;

    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedDataMaster> expectedData;

    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResults> runResults;
}
