package com.moon.trackingsystem.models;

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
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "person_team", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temp_password_id")
    private TempPassword tempPassword;

    public void addTeam(Team team) {
        if(teams == null)
            teams = new ArrayList<>();
        teams.add(team);
    }//end addTeam

    public Person(String firstName, String lastName, String email, String role, String phoneNumber, String bio, String password, List<Team> teams, TempPassword tempPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.password = password;
        this.teams = teams;
        this.tempPassword = tempPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public TempPassword getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(TempPassword tempPassword) {
        this.tempPassword = tempPassword;
    }

}//end class