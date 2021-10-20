package com.ash.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operating_unit")
public class OperatingUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "operating_unit_name")
    private String operatingUnitName;


    // mapping with department to delete child for deleted parent
    @OneToMany(mappedBy = "operatingUnit",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnore
    private List<Department> department;


    // all argument constructor without id field
    public OperatingUnit(String operatingUnitName) {
        this.operatingUnitName = operatingUnitName;
    }
}
