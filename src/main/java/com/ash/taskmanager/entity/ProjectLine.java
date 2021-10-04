package com.ash.taskmanager.entity;

import com.ash.taskmanager.authentication.UserDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "project_line")
public class ProjectLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task_ane")
    private String taskName;

    @Column(name = "is_milestone")
    private Boolean isMilestone;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "effort")
    private Double effort;

    @Column(name = "confidence")
    private Double confidence;

    @Column(name = "slack")
    private Double slack;

    @Column(name = "total_duration")
    private Double totalDuration;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "isPrerequisite")
    private Boolean isPrerequisite;

    @Column(name = "message")
    private String message;


    // mapping with Project Header
    @ManyToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "project_header")
    private ProjectHeader projectHeader;


    // mapping with Project Details to fetch resource person's information
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "resource")
    private UserDetails resource;


    // mapping with this table to track the prerequisite no
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "prerequisite_no")
    private ProjectLine prerequisite;


    // all argument constructor without id field
    public ProjectLine(String taskName,
                       Boolean isMilestone,
                       Double duration,
                       Double effort,
                       Double confidence,
                       Double slack,
                       Double totalDuration,
                       Date startDate,
                       Date endDate,
                       Boolean isPrerequisite,
                       String message) {
        this.taskName = taskName;
        this.isMilestone = isMilestone;
        this.duration = duration;
        this.effort = effort;
        this.confidence = confidence;
        this.slack = slack;
        this.totalDuration = totalDuration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPrerequisite = isPrerequisite;
        this.message = message;
    }
}
