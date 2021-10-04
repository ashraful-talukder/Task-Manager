package com.ash.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    // all argument constructor without id field
    public OperatingUnit(String operatingUnitName) {
        this.operatingUnitName = operatingUnitName;
    }
}
