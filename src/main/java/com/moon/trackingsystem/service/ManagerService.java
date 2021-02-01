package com.moon.trackingsystem.service;

import com.moon.trackingsystem.models.card.Card;
import com.moon.trackingsystem.models.card.CardRepository;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.project.ProjectRepository;
import com.moon.trackingsystem.models.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {
    private PersonRepository personRepository;
    private ProjectRepository projectRepository;
    private CardRepository cardRepository;

    public ManagerService(PersonRepository personRepository, ProjectRepository projectRepository, CardRepository cardRepository) {
        this.personRepository = personRepository;
        this.projectRepository = projectRepository;
        this.cardRepository = cardRepository;
    }


    public List<Project> getAllProjectsForPersonID(int personID) {
        if(personRepository.existsById(personID)) {
            List<Project> projects = new ArrayList<>();
            for(Team team : personRepository.findById(personID).get().getTeams())
                projects.addAll(team.getProjects());
            return projects;
        }
        return null;
    }//end getAllProjectsForPersonID

    public List<List<Card>> getAllCardsForProjectID(int projectID) {
        if(projectRepository.existsById(projectID)) {
            List<List<Card>> cards = new ArrayList<>();
            for(Card card : projectRepository.findById(projectID).get().getCards())
                placeCardInItsIDColumn(cards, card);
            return cards;
        }
        return null;
    }//end getAllCardsForProjectID

    private void placeCardInItsIDColumn(List<List<Card>> cards, Card card) {
        if(cards.size() == 0)
            cards.add(new ArrayList<>());
        for(int i=0;i<cards.size();i++)
            for(int j=0;j<cards.get(i).size();j++)
                if(cards.get(i).get(j).getAttendant() == card.getAttendant()) {
                    cards.get(i).add(card);
                    return;
                }
        cards.add(new ArrayList<>());
        cards.get(cards.size()-1).add(card);
    }//end placeCardInItsIDColumn

    public boolean addCardForProjectID(int projectID, Card card) {
        if(projectRepository.existsById(projectID) && card != null) {
            Project project = projectRepository.findById(projectID).get();
            project.getCards().add(card);
            projectRepository.save(project);
            cardRepository.save(card);
            return true;
        }
        return false;
    }//end addCardForProjectID

    public Card retrieveCard(int cardID) {
        if(cardRepository.existsById(cardID))
            return cardRepository.findById(cardID).get();
        return null;
    }//end retrieveCard

    public boolean alterCard(Card card) {
        if(card != null) {
            cardRepository.save(card);
            return true;
        }
        return false;
    }//end alterCard


}
