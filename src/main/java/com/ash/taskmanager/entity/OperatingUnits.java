package com.ash.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "operating_unit")
public class OperatingUnits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "operating_unit_name")
    private String operatingUnitName;
}
