package com.ash.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "sub_section")
public class SubSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


}
