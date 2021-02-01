package com.moon.trackingsystem.models.attachment;

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
@Table(name = "attachment")


public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "card_id")
//    private Card attachmentCard;


}
