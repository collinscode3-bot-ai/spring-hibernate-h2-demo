package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "test_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestData {
    @Id
    private String testDataId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @Lob
    private String uploadedTestData;
    private String staticHeaderInfo;

    @Lob
    private String finalTestData;
    private String finalHeaderInfo;

    @OneToMany(mappedBy = "testData", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ExpectedData> expectedData;
}
