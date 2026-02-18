package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationParameterMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parameterId;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private ValidationsMaster validation;

    private Integer sequenceNo;
    private String parameterType;
    private String parameterDataType;
    private String parameterValue;
}
