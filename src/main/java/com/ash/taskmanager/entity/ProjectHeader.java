package com.ash.taskmanager.entity;

import com.ash.taskmanager.authentication.UserDetails;
import com.ash.taskmanager.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    @Column(name = "is_revoked_project")
    private Boolean isRevokedProject = false;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private Status projectStatus;


    // mapping relation with weekends
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinTable(name = "project_weekend",
                joinColumns = @JoinColumn(name = "project_header_id"),
                inverseJoinColumns = @JoinColumn(name = "weekends_id"))
    private List<Weekend> weekends;


    // mapping for fetch the details of project manager's information
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "product_manager")
    private UserDetails projectManger;


    // mapping for fetch the details of product manager's or client's information
    @OneToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinColumn(name = "product_manager")
    private UserDetails productManager;


    // mapping to track tagged persons
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH})
    @JoinTable(name = "tagged_persons",
                joinColumns = @JoinColumn(name = "project_header_id"),
                inverseJoinColumns = @JoinColumn(name = "user_details_id"))
    private List<UserDetails> tagPersons;


    // mapping with the project lines
    @OneToMany(mappedBy = "projectHeader",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    private List<ProjectLine> projectLines;


    // all argument constructor without id field
    public ProjectHeader(String projectName,
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
