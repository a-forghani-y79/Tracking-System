package com.moon.trackingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date crated_at;
    private Date published_at;
    @OneToMany(mappedBy = "sectionProject", cascade = CascadeType.ALL)
    private List<Section> sections;
    @OneToMany(mappedBy = "ticketProject", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "cardProject", cascade = CascadeType.ALL)
    private List<Card> cards;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    public void addSection(Section section) {
        if(sections == null)
            sections = new ArrayList<>();
        section.setSectionProject(this);
        sections.add(section);
    }//end addSection

    public void addTicket(Ticket ticket) {
        if(tickets == null)
            tickets = new ArrayList<>();
        ticket.setTicketProject(this);
        tickets.add(ticket);
    }//end addTicket

    public void addCard(Card card) {
        if(cards == null)
            cards = new ArrayList<>();
        card.setCardProject(this);
        cards.add(card);
    }//end addCard

    public Project(String name, Date crated_at, Date published_at) {
        this.name = name;
        this.crated_at = crated_at;
        this.published_at = published_at;
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

    public Date getCrated_at() {
        return crated_at;
    }

    public void setCrated_at(Date crated_at) {
        this.crated_at = crated_at;
    }

    public Date getPublished_at() {
        return published_at;
    }

    public void setPublished_at(Date published_at) {
        this.published_at = published_at;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
