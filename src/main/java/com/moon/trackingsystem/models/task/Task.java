package com.moon.trackingsystem.models.task;

import com.moon.trackingsystem.models.card.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private boolean status;
    private int attendant;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card taskCard;


    public Task(String description, boolean status, int attendant) {
        this.description = description;
        this.status = status;
        this.attendant = attendant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAttendant() {
        return attendant;
    }

    public void setAttendant(int attendant) {
        this.attendant = attendant;
    }

    public Card getTaskCard() {
        return taskCard;
    }

    public void setTaskCard(Card taskCard) {
        this.taskCard = taskCard;
    }
}
