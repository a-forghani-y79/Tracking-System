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
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "card_id")
//    private Card taskCard;



}
