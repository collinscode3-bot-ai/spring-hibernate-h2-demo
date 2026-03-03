package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contract_field_properties")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContractFieldProperty extends BaseAuditEntity {
    @Id
    private String fieldId;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private String jsonKey;
    private String isMandatory; // Y/N
    private String fieldDataType;
    private String fieldValueType;
    private String autoGenerationField; // Y/N
    private String fieldGenerationType;
    private String fieldFormat;
}
