package com.moon.trackingsystem.models.card;

import com.moon.trackingsystem.models.comment.Comment;
import com.moon.trackingsystem.models.project.Project;
import com.moon.trackingsystem.models.task.Task;
import com.moon.trackingsystem.models.attachment.Attachment;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "project_id")
//    private Project cardProject;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="card_id" )
    private List<Comment> comments;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="card_id" )
    private List<Attachment> attachments;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="card_id" )
    private List<Task> tasks;

    public void addComment(Comment comment) {
        if(comments == null)
            comments = new ArrayList<>();
      //  comment.setCommentCard(this);
        comments.add(comment);
    }//end addComment

    public void addAttachment(Attachment attachment) {
        if(attachments == null)
            attachments = new ArrayList<>();
        //attachment.setAttachmentCard(this);
        attachments.add(attachment);
    }//end addAttachment

    public void addTask(Task task) {
        if(tasks == null)
            tasks = new ArrayList<>();
      //  task.setTaskCard(this);
        tasks.add(task);
    }//end addTask



}
