package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "validations")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Validation extends BaseAuditEntity {
    @Id
    private String validationId;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerification verification;

    private String sourceData;
    private String validationType;
    private String validationName;
    private Integer sequenceNo;
    private String expectedOutcomeValue;

    @ManyToOne
    @JoinColumn(name = "payload_contract_id")
    private Contract payloadContract;

    private String payloadFormat;

    @Lob
    private String errorMessages;

    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ValidationParameter> parameters;

    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedData> expectedData;

    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResult> runResults;
}
