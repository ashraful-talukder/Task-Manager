package com.ash.taskmanager.entity;

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
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "section_name")
    private String sectionName;


    // relation mapping with Department
    @ManyToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;


    // mapping with department to delete child for deleted parent
    @OneToMany(mappedBy = "section",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SubSection> subSections;


    // all argument constructor without id field
    public Section(String sectionName) {
        this.sectionName = sectionName;
    }
}
