package com.moon.trackingsystem.models.comment;

import com.moon.trackingsystem.models.card.Card;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String text;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card commentCard;


    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Card getCommentCard() {
        return commentCard;
    }

    public void setCommentCard(Card commentCard) {
        this.commentCard = commentCard;
    }
}
