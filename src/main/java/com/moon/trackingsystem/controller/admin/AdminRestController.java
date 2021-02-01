package com.moon.trackingsystem.controller.admin;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.project.ProjectRepository;
import com.moon.trackingsystem.models.team.Team;
import com.moon.trackingsystem.models.team.TeamRepository;
import com.moon.trackingsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team-rest")
public class AdminRestController {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/create-team")
    public boolean createTeam(@RequestBody Team team) {
        return new AdminService(projectRepository, teamRepository, personRepository).crateTeam(team);
    }

    @PostMapping("/add-project")
    public boolean addProject(@RequestBody Project project, int teamId) {
        return new AdminService(projectRepository, teamRepository, personRepository).addProject(project, teamId);
    }

    @PostMapping("/add-member-to-team")
    public boolean addMemberToTeam(@RequestBody List<Integer> people, int teamId) {
        return new AdminService(projectRepository, teamRepository, personRepository).addMemberToCurrentTem(people, teamId);

    }

    @GetMapping("/all-people")
    public List<Person> getPeople() {
        return new AdminService(projectRepository, teamRepository, personRepository).getPeople();
    }

    @GetMapping("/all-teams")
    public List<Team> getAllTeam() {
        return new AdminService(projectRepository, teamRepository, personRepository).getTeams();
    }

    @GetMapping("/all-projects")
    public List<Project> getAllProjects() {
        return new AdminService(projectRepository, teamRepository, personRepository).getProjects();
    }

    @GetMapping("/all-people-for-team")
    public List<Person> getPeopleForTeam(@RequestBody int teamId) {
        return new AdminService(projectRepository, teamRepository, personRepository).getPeopleForTeam(teamId);
    }

    @GetMapping("/all-projects-for-team")
    public List<Project> getAllProjectsForTeam(@RequestBody int teamId) {
        return new AdminService(projectRepository, teamRepository, personRepository).getAllProjectsForTeam(teamId);
    }

    @DeleteMapping("/delete-person")
    public boolean deletePerson(@RequestBody int person) {
        return new AdminService(projectRepository, teamRepository, personRepository).deletePerson(person);

    }


}
