package com.moon.trackingsystem.models.comment;

import com.moon.trackingsystem.models.comment.Comment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentRepositoryImpl {
    private EntityManager entityManager;

    public CommentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Comment comment) {
        Session session = entityManager.unwrap(Session.class);
        session.save(comment);
        System.out.println(comment);
    }//end add

    @Transactional
    public Comment get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Comment.class, id);
    }//end get

    @Transactional
    public List<Comment> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Comment> query = session.createQuery("from Comment", Comment.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Comment update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Comment comment = session.get(Comment.class, id);
        if(comment == null)
            return null;
        else {
            session.update(comment);
            return comment;
        }
    }//end update

    @Transactional
    public Comment delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Comment comment = session.get(Comment.class, id);
        if(comment == null)
            return null;
        else {
            session.delete(comment);
            return comment;
        }
    }//end delete
}
