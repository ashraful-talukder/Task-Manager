package com.ash.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "department_name")
    private String departmentName;


    // relation mapping with OperatingUnits
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "operating_unit_id")
    private OperatingUnits operatingUnits;
}
