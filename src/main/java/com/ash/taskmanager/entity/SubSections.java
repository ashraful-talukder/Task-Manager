package com.ash.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sub_sections")
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


    // all argument constructor without id field
    public SubSections(String subSectionName) {
        this.subSectionName = subSectionName;
    }
}
