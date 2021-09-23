package com.ash.taskmanager.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_header")
public class ProjectHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_details")
    private String projectDetails;

    @Column(name = "product_name")
    private String ProductName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "total_milestone")
    private Integer totalMilestone;

    @Column(name = "completed_milestone")
    private Integer completedMilestone;

    @Column(name = "total_tasks")
    private Integer totalTasks;

    @Column(name = "completed_tasks")
    private Integer completedTasks;

    @Column(name = "percentage_of_completed_project")
    private Double percentageOfCompletedProject;

    @Column(name = "is_revocate_project")
    private Boolean isRevocateProject;
}
