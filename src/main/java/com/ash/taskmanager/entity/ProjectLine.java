package com.ash.taskmanager.entity;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "prerequisite")
    private Boolean prerequisite;

}
