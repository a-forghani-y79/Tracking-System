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
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private String description;
    private String author;
    private Date created_at;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project ticketProject;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public void addAnswer(Answer answer) {
        if(answers == null)
            answers = new ArrayList<>();
        answer.setTicket(this);
        answers.add(answer);
    }//end addAnswer

    public Ticket(String subject, String description, String author, Date created_at) {
        this.subject = subject;
        this.description = description;
        this.author = author;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Project getTicketProject() {
        return ticketProject;
    }

    public void setTicketProject(Project ticketProject) {
        this.ticketProject = ticketProject;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
