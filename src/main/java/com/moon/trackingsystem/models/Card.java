package com.moon.trackingsystem.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project cardProject;
    @OneToMany(mappedBy = "commentCard",cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "attachmentCard",cascade = CascadeType.ALL)
    private List<Attachment> attachments;
    @OneToMany(mappedBy = "taskCard",cascade = CascadeType.ALL)
    private List<Task> tasks;

    public void addComment(Comment comment) {
        if(comments == null)
            comments = new ArrayList<>();
        comment.setCommentCard(this);
        comments.add(comment);
    }//end addComment

    public void addAttachment(Attachment attachment) {
        if(attachments == null)
            attachments = new ArrayList<>();
        attachment.setAttachmentCard(this);
        attachments.add(attachment);
    }//end addAttachment

    public void addTask(Task task) {
        if(tasks == null)
            tasks = new ArrayList<>();
        task.setTaskCard(this);
        tasks.add(task);
    }//end addTask


    public Card(String title, String description, Date created_at, Date deadLine) {
        this.title = title;
        this.description = description;
        this.created_at = created_at;
        this.deadLine = deadLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getCardProject() {
        return cardProject;
    }

    public void setCardProject(Project cardProject) {
        this.cardProject = cardProject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
