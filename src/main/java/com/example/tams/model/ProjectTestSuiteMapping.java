package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTestSuiteMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectMaster project;

    @ManyToOne
    @JoinColumn(name = "test_suite_id")
    private TestSuiteMaster testSuite;
}
