package com.moon.trackingsystem.models.task;

import com.moon.trackingsystem.models.task.Task;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskRepositoryImpl {
    private EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.save(task);
        System.out.println(task);
    }//end add

    @Transactional
    public Task get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Task.class, id);
    }//end get

    @Transactional
    public List<Task> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Task> query = session.createQuery("from Task", Task.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Task update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Task task = session.get(Task.class, id);
        if(task == null)
            return null;
        else {
            session.update(task);
            return task;
        }
    }//end update

    @Transactional
    public Task delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Task task = session.get(Task.class, id);
        if(task == null)
            return null;
        else {
            session.delete(task);
            return task;
        }
    }//end delete


}
