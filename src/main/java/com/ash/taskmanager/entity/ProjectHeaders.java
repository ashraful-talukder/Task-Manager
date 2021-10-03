package com.ash.taskmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "project_headers")
public class ProjectHeaders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_details")
    private String projectDetails;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "total_milestones")
    private Integer totalMilestones;

    @Column(name = "completed_milestones")
    private Integer completedMilestones;

    @Column(name = "total_tasks")
    private Integer totalTasks;

    @Column(name = "completed_tasks")
    private Integer completedTasks;

    @Column(name = "percentage_of_completed_project")
    private Double percentageOfCompletedProject;

    @Column(name = "is_revocate_project")
    private Boolean isRevocateProject = false;


    // all argument constructor without id field
    public ProjectHeaders(String projectName,
                          String projectDetails,
                          String productName,
                          Date startDate,
                          Date endDate,
                          Integer totalMilestones,
                          Integer completedMilestones,
                          Integer totalTasks,
                          Integer completedTasks,
                          Double percentageOfCompletedProject) {
        this.projectName = projectName;
        this.projectDetails = projectDetails;
        this.productName = productName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMilestones = totalMilestones;
        this.completedMilestones = completedMilestones;
        this.totalTasks = totalTasks;
        this.completedTasks = completedTasks;
        this.percentageOfCompletedProject = percentageOfCompletedProject;
    }
}
