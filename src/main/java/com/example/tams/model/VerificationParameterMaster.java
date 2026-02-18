package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationParameterMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parameterId;

    private String paramKey;
    private String valueSource;
    private String paramValue;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerificationsMaster verification;

    private Integer sequenceNo;
    private String valuePath;
    private String valueDataType;
}
