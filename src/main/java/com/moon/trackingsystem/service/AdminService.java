package com.moon.trackingsystem.service;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.project.ProjectRepository;
import com.moon.trackingsystem.models.team.Team;
import com.moon.trackingsystem.models.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private ProjectRepository projectRepository;
    private TeamRepository teamRepository;
    private PersonRepository personRepository;

    public AdminService(ProjectRepository projectRepository, TeamRepository teamRepository, PersonRepository personRepository) {
        this.projectRepository = projectRepository;
        this.teamRepository = teamRepository;
        this.personRepository = personRepository;
    }


    public boolean crateTeam(Team team) {
        if (team != null) {
            projectRepository.saveAll(team.getProjects());
            teamRepository.save(team);
            return true;
        }
        return false;
    }

    public boolean addProject(Project project, int teamId) {
        if (project != null) {
            if (teamRepository.existsById(teamId)) {
                Team team = teamRepository.findById(teamId).get();
                team.getProjects().add(project);
                projectRepository.save(project);
                teamRepository.save(team);
                return true;
            }
        }
        return false;
    }

    public boolean addMemberToCurrentTem(List<Integer> people, int teamId) {
        if (people.size() != 0 && teamRepository.existsById(teamId)) {
            Team team = teamRepository.findById(teamId).get();
            team.getPeople().addAll(personRepository.findAllById(people));
            teamRepository.save(team);
            return true;
        }
        return false;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public List<Person> getPeopleForTeam(int teamId) {
        if (teamRepository.existsById(teamId)) {
            return teamRepository.findById(teamId).get().getPeople();
        }
        return null;
    }


    public List<Project> getAllProjectsForTeam(int teamId) {
        if (teamRepository.existsById(teamId))
            return teamRepository.findById(teamId).get().getProjects();
        return null;
    }

    public boolean deletePerson(int personId) {
        if (personRepository.existsById(personId)) {
            personRepository.deleteById(personId);
            return true;
        }
        return false;
    }
    public List<Team> getTeams(){
        return teamRepository.findAll();
    }
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }


}
