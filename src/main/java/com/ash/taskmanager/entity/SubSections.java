package com.ash.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "sub_section")
public class SubSections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sub_section_name")
    private String subSectionName;

    // relation mapping with section
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Sections sections;
}
