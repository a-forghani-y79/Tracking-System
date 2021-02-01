package com.moon.trackingsystem.models.project;

import com.moon.trackingsystem.models.project.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class ProjectRepositoryImpl {
    private EntityManager entityManager;

    public ProjectRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Project project) {
        Session session = entityManager.unwrap(Session.class);
        session.save(project);
        System.out.println(project);
    }//end add

    @Transactional
    public Project get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Project.class, id);
    }//end get

    @Transactional
    public List<Project> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Project> query = session.createQuery("from Project", Project.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Project update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Project project = session.get(Project.class, id);
        if(project == null)
            return null;
        else {
            session.update(project);
            return project;
        }
    }//end update

    @Transactional
    public Project delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Project project = session.get(Project.class, id);
        if(project == null)
            return null;
        else {
            session.delete(project);
            return project;
        }
    }//end delete


}
