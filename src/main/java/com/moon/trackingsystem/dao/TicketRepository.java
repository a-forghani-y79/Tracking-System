package com.moon.trackingsystem.dao;

import com.moon.trackingsystem.models.Ticket;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepository {
    private EntityManager entityManager;

    public TicketRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Ticket ticket) {
        Session session = entityManager.unwrap(Session.class);
        session.save(ticket);
        System.out.println(ticket);
    }//end add

    @Transactional
    public Ticket get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Ticket.class, id);
    }//end get

    @Transactional
    public List<Ticket> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Ticket> query = session.createQuery("from Ticket", Ticket.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Ticket update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Ticket ticket = session.get(Ticket.class, id);
        if(ticket == null)
            return null;
        else {
            session.update(ticket);
            return ticket;
        }
    }//end update

    @Transactional
    public Ticket delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Ticket ticket = session.get(Ticket.class, id);
        if(ticket == null)
            return null;
        else {
            session.delete(ticket);
            return ticket;
        }
    }//end delete


}
