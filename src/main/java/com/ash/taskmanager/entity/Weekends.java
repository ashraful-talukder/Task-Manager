package com.ash.taskmanager.entity;

import com.ash.taskmanager.enums.Weekend;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "weekend")
public class Weekends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "weekend_day")
    @Enumerated(EnumType.STRING)
    private Weekend weekendDay;


    // mapping relation with project header
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinTable(name = "project_weekend",
                joinColumns = @JoinColumn(name = "weekends_id"),
                inverseJoinColumns = @JoinColumn(name = "project_header_id"))
    private List<ProjectHeaders> projectHeaders;


    // all argument constructor without id field
    public Weekends(Weekend weekendDay) {
        this.weekendDay = weekendDay;
    }
}
