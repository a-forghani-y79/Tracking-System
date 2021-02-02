package com.moon.trackingsystem.controller.admin;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.project.ProjectRepository;
import com.moon.trackingsystem.models.team.Team;
import com.moon.trackingsystem.models.team.TeamRepository;
import com.moon.trackingsystem.service.AdminService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://lohalhost:3000")
@RestController
@RequestMapping("/team-rest")
public class AdminRestController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/create-team")
    public boolean createTeam(@RequestBody Team team) {
        return adminService.crateTeam(team);
    }

    @PostMapping("/add-project")
    public boolean addProject(@RequestBody Project project, int teamId) {
        return adminService.addProject(project, teamId);
    }

    @PostMapping("/add-member-to-team")
    public boolean addMemberToTeam(@RequestBody List<Integer> people, int teamId) {
        return adminService.addMemberToCurrentTeam(people, teamId);

    }

    @GetMapping("/all-people")
    public List<Person> getPeople() {
        return adminService.getPeople();
    }

    @GetMapping("/all-teams")
    public List<Team> getAllTeam() {
        return adminService.getTeams();
    }

    @GetMapping("/all-projects")
    public List<Project> getAllProjects() {
        return adminService.getProjects();
    }

    @GetMapping("/all-people-for-team")
    public List<Person> getPeopleForTeam(@RequestBody int teamId) {
        return adminService.getPeopleForTeam(teamId);
    }

    @GetMapping("/all-projects-for-team")
    public List<Project> getAllProjectsForTeam(@RequestBody int teamId) {
        return adminService.getAllProjectsForTeam(teamId);
    }

    @DeleteMapping("/delete-person")
    public boolean deletePerson(@RequestBody int person) {
        return adminService.deletePerson(person);

    }

    @PostMapping(value = "/add-person")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @PostMapping(value = "/invite-person")
    public void addPerson(@RequestBody String email) throws IOException, MessagingException {
        adminService.invitePerson(email);
    }

}

@Data
class AddProject {
    private Project project;
    private int teamId;
}

@Data
class AddMemberToTeam {
    private List<Integer> peopleId;
    private int teamId;
}
