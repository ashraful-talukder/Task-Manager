package com.ash.taskmanager.authentication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private Boolean locked = false;
    private Boolean enabled = false;


    // bi-directional relation mapping with user_details
    @OneToOne(mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private UserDetails userDetails;


    // all argument constructor without id field
    public Users(String email,
                 String password,
                 UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
