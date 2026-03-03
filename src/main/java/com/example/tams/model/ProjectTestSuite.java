package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project_test_suites")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTestSuite extends BaseAuditEntity {
    @Id
    private String mappingId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "test_suite_id")
    private TestSuite testSuite;
}
