package com.moon.trackingsystem.models.team;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.project.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "person_team", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> persons;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Project> projects;

    public void addPerson(Person person) {
        if(persons == null)
            persons = new ArrayList<>();
        persons.add(person);
    }//end addPerson

    public void addProjects(Project project) {
        if(projects == null)
            projects = new ArrayList<>();
        project.setTeam(this);
        projects.add(project);
    }//end addProjects

    public Team(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
