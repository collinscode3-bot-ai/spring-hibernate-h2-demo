package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "verification_parameters")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class VerificationParameter extends BaseAuditEntity {
    @Id
    private String parameterId;

    private String paramKey;
    private String valueSource;
    private String paramValue;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerification verification;

    private Integer sequenceNo;
    private String valuePath;
    private String valueDataType;
}
