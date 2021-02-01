package com.moon.trackingsystem.models.ticket;

import com.moon.trackingsystem.models.answer.Answer;
import com.moon.trackingsystem.models.project.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String subject;
    private String description;
    private String author;
    private Date created_at;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<Answer> answers ;


}
