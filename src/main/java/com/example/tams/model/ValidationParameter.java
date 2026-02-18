package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "validation_parameters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationParameter {
    @Id
    private String parameterId;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private Validation validation;

    private Integer sequenceNo;
    private String parameterType;
    private String parameterDataType;
    private String parameterValue;
}
