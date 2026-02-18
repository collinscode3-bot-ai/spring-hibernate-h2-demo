package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractFieldProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldId;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractMaster contract;

    private String jsonKey;
    private String isMandatory; // Y/N
    private String fieldDataType;
    private String fieldValueType;
    private String autoGenerationField; // Y/N
    private String fieldGenerationType;
    private String fieldFormat;
}
