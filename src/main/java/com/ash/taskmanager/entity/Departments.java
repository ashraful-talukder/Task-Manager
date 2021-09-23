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
}
