package com.ash.taskmanager.entity;

import com.ash.taskmanager.enums.Weekends;
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
public class Weekend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "weekend_day")
    @Enumerated(EnumType.STRING)
    private Weekends weekendsDay;


    // mapping relation with project header
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinTable(name = "project_weekend",
                joinColumns = @JoinColumn(name = "weekends_id"),
                inverseJoinColumns = @JoinColumn(name = "project_header_id"))
    private List<ProjectHeader> projectHeaders;


    // all argument constructor without id field
    public Weekend(Weekends weekendsDay) {
        this.weekendsDay = weekendsDay;
    }
}
