package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseAuditEntity {
    @Id
    private String projectId;
    private String projectName;
    private String projectDesc;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ProjectTestSuite> suiteMappings;
}
