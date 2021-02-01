package com.moon.trackingsystem.dao;

import com.moon.trackingsystem.models.Attachment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class AttachmentRepository {
    private EntityManager entityManager;

    public AttachmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Attachment attachment) {
        Session session = entityManager.unwrap(Session.class);
        session.save(attachment);
        System.out.println(attachment);
    }//end add

    @Transactional
    public Attachment get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Attachment.class, id);
    }//end get

    @Transactional
    public List<Attachment> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Attachment> query = session.createQuery("from Attachment", Attachment.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Attachment update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Attachment attachment = session.get(Attachment.class, id);
        if(attachment == null)
            return null;
        else {
            session.update(attachment);
            return attachment;
        }
    }//end update

    @Transactional
    public Attachment delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Attachment attachment = session.get(Attachment.class, id);
        if(attachment == null)
            return null;
        else {
            session.delete(attachment);
            return attachment;
        }
    }//end delete


}
