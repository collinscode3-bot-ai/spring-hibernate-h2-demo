package com.example.tams.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @Lob
    private String contractSchemaJson;

    @Lob
    private String contractBaseJson;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ContractFieldProperties> fieldProperties;

    @OneToMany(mappedBy = "triggerPayloadContract", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TestCaseMaster> testCases;
}
