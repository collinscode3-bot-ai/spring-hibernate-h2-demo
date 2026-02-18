package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestExecutionMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long executionId;

    @ManyToOne
    @JoinColumn(name = "test_suite_id")
    private TestSuiteMaster testSuite;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    @OneToMany(mappedBy = "execution", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestRunResults> runResults;
}
