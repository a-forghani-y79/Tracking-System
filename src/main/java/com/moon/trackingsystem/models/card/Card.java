package com.moon.trackingsystem.models.card;

import com.moon.trackingsystem.models.attachment.Attachment;
import com.moon.trackingsystem.models.comment.Comment;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.task.Task;
import lombok.*;
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
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Date created_at;
    private Date deadLine;


    @OneToOne
    private Person manager;
    @OneToMany
    @JoinColumn(name = "card_id")
    private List<Comment> comments;

    @OneToMany
    @JoinColumn(name = "card_id")
    private List<Attachment> attachments;

    @OneToMany
    @JoinColumn(name = "card_id")
    private List<Task> tasks;





}
