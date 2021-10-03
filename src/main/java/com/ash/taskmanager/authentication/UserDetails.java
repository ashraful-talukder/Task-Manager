package com.ash.taskmanager.authentication;

import com.ash.taskmanager.entity.Departments;
import com.ash.taskmanager.entity.OperatingUnits;
import com.ash.taskmanager.entity.Sections;
import com.ash.taskmanager.entity.SubSections;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "designation")
    private String designation;

    // relation mapping with Operating Unit
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "operating_unit_id")
    private OperatingUnits operatingUnit;

    // relation mapping with Department
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Departments department;

    // relation mapping with Section
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "section_id")
    private Sections sections;

    // relation mapping with Sub-Section
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "sub_section_id")
    private SubSections subSection;
}
