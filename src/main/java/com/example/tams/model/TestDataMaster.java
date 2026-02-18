package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDataMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testDataId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCaseMaster testCase;

    @Lob
    private String uploadedTestData;
    private String staticHeaderInfo;

    @Lob
    private String finalTestData;
    private String finalHeaderInfo;

    @OneToMany(mappedBy = "testData", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedDataMaster> expectedData;
}
