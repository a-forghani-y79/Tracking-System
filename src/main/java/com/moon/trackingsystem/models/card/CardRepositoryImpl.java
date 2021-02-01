package com.moon.trackingsystem.models.card;

import com.moon.trackingsystem.models.card.Card;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CardRepositoryImpl {
    private EntityManager entityManager;

    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Card card) {
        Session session = entityManager.unwrap(Session.class);
        session.save(card);
        System.out.println(card);
    }//end add

    @Transactional
    public Card get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Card.class, id);
    }//end get

    @Transactional
    public List<Card> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Card> query = session.createQuery("from Card", Card.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Card update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Card card = session.get(Card.class, id);
        if(card == null)
            return null;
        else {
            session.update(card);
            return card;
        }
    }//end update

    @Transactional
    public Card delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Card card = session.get(Card.class, id);
        if(card == null)
            return null;
        else {
            session.delete(card);
            return card;
        }
    }//end delete


}
