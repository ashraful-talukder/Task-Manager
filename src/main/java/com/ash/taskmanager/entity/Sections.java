package com.ash.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Sections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "section_name")
    private String sectionName;
}
