package com.ash.taskmanager.authentication;

import com.ash.taskmanager.entity.*;
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
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "designation")
    private String designation;


    // relation mapping with Users
    @OneToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;


    // relation mapping with Operating Unit
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "operating_unit_id")
    private OperatingUnit operatingUnit;


    // relation mapping with Department
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;


    // relation mapping with Section
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "section_id")
    private Section section;


    // relation mapping with Sub-Section
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "sub_section_id")
    private SubSection subSection;


    // mapping to complete the tagged person table
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinTable(name = "tagged_persons",
                joinColumns = @JoinColumn(name = "user_details_id"),
                inverseJoinColumns = @JoinColumn(name = "project_header_id"))
    @JsonIgnore
    private List<ProjectHeader> projectHeaders;


    // all argument constructor without id field
    public UserDetails(String name,
                       String mobile,
                       String designation) {
        this.name = name;
        this.mobile = mobile;
        this.designation = designation;
    }
}
