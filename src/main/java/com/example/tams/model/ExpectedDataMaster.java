package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpectedDataMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expectedDataId;

    @ManyToOne
    @JoinColumn(name = "test_data_id")
    private TestDataMaster testData;

    @ManyToOne
    @JoinColumn(name = "verification_id")
    private TestCaseVerificationsMaster verification;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private ValidationsMaster validation;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCaseMaster testCase;

    @Lob
    private String expectedData;
}
