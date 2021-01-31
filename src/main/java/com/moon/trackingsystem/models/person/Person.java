package com.moon.trackingsystem.models.person;

import com.moon.trackingsystem.models.team.Team;
import com.moon.trackingsystem.models.tempPassword.TempPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String phoneNumber;
    private String bio;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Team> team;
    @OneToOne
    private TempPassword tempPassword;


}
