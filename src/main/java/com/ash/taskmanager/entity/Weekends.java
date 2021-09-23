package com.ash.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "weekend")
public class Weekends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "weekend_day")
    private String weekendDay;
}
