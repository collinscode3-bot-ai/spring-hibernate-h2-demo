package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "contracts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    private String contractId;

    @Lob
    private String contractSchemaJson;

    @Lob
    private String contractBaseJson;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ContractFieldProperty> fieldProperties;

    @OneToMany(mappedBy = "triggerPayloadContract", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCase> testCases;
}
