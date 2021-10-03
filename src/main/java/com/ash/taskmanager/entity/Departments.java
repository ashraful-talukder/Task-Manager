package com.ash.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
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


    // all argument constructor without id field
    public Departments(String departmentName) {
        this.departmentName = departmentName;
    }
}
