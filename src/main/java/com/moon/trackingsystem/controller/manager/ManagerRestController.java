package com.moon.trackingsystem.controller.manager;

import com.moon.trackingsystem.models.card.Card;
import com.moon.trackingsystem.models.card.CardRepository;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.project.ProjectRepository;
import com.moon.trackingsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager-rest")
public class ManagerRestController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private CardRepository cardRepository;


    @GetMapping("/list-projects/{personID}")
    public List<Project> getAllProjects(@PathVariable int personID) {
        return new ManagerService(personRepository, projectRepository, cardRepository).getAllProjectsForPersonID(personID);
    }//end getAllProjects

    @GetMapping("/list-cards/{projectID}")
    public List<List<Card>> getListedCardsForProjectID(@PathVariable int projectID) {
        return new ManagerService(personRepository, projectRepository, cardRepository).getAllCardsForProjectID(projectID);
    }//end getListedCardsForProjectID

    @GetMapping("/retrieve-card/{cardID}")
    public Card retrieveCard(@PathVariable int cardID) {
        return new ManagerService(personRepository, projectRepository, cardRepository).retrieveCard(cardID);
    }//end retrieveCard

    @PutMapping("/alter-card")
    public boolean alterCard(@RequestBody Card card) {
        return new ManagerService(personRepository, projectRepository, cardRepository).alterCard(card);
    }//end alterCard


}//end ManagerRestController
