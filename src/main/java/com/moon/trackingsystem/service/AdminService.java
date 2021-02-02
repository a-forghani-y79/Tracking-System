package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.SendEmailModel;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.project.ProjectRepository;
import com.moon.trackingsystem.models.team.Team;
import com.moon.trackingsystem.models.team.TeamRepository;
import com.moon.trackingsystem.models.token.Token;
import com.moon.trackingsystem.models.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class AdminService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SendEmail sendEmail;
    @Autowired
    private TokenRepository tokenRepository;

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

    public boolean addMemberToCurrentTeam(List<Integer> people, int teamId) {
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

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public void invitePerson(String email) throws IOException, MessagingException {
        String tokenCode = generateTheTokenCode();
        SendEmailModel sendEmailModel = new SendEmailModel();
        sendEmailModel.setDescription("http://localhost:8080/"+tokenCode);
        sendEmailModel.setSubject("لینک ثبت نام");
        sendEmailModel.setTo(email);
        sendEmail.sendEmail(sendEmailModel);
        Token token = new Token().builder().code(tokenCode).email("email").build();
        tokenRepository.save(token);

    }
    public  String generateTheTokenCode(){

            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() <6) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            return saltStr;


    }



}
