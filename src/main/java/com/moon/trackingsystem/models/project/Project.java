package com.moon.trackingsystem.models.project;

import com.moon.trackingsystem.models.card.Card;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.section.Section;
import com.moon.trackingsystem.models.team.Team;
import com.moon.trackingsystem.models.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
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

    @OneToMany

    @JoinColumn(name = "project_id")
    private List<Section> sections;


    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Ticket> tickets;


    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Card> cards;
}
