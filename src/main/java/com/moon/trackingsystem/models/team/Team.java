package com.moon.trackingsystem.models.team;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.project.Project;
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
@Table(name = "team")
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany()
    @JoinColumn(name = "team_id")
    private List<Project> projects;

}
