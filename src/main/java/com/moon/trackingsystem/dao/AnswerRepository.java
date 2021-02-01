package com.moon.trackingsystem.dao;

import com.moon.trackingsystem.models.Answer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class AnswerRepository {
    private EntityManager entityManager;

    public AnswerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Answer answer) {
        Session session = entityManager.unwrap(Session.class);
        session.save(answer);
        System.out.println(answer);
    }//end add

    @Transactional
    public Answer get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Answer.class, id);
    }//end get

    @Transactional
    public List<Answer> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Answer> query = session.createQuery("from Answer", Answer.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Answer update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Answer answer = session.get(Answer.class, id);
        if(answer == null)
            return null;
        else {
            session.update(answer);
            return answer;
        }
    }//end update

    @Transactional
    public Answer delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Answer answer = session.get(Answer.class, id);
        if(answer == null)
            return null;
        else {
            session.delete(answer);
            return answer;
        }
    }//end delete



}
