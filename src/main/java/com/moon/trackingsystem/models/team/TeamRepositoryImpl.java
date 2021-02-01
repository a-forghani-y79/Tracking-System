package com.moon.trackingsystem.models.team;

import com.moon.trackingsystem.models.team.Team;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class TeamRepositoryImpl {
    private EntityManager entityManager;

    public TeamRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Team team) {
        Session session = entityManager.unwrap(Session.class);
        session.save(team);
        System.out.println(team);
    }//end add

    @Transactional
    public Team get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Team.class, id);
    }//end get

    @Transactional
    public List<Team> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Team> query = session.createQuery("from Team", Team.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Team update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Team team = session.get(Team.class, id);
        if(team == null)
            return null;
        else {
            session.update(team);
            return team;
        }
    }//end update

    @Transactional
    public Team delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Team team = session.get(Team.class, id);
        if(team == null)
            return null;
        else {
            session.delete(team);
            return team;
        }
    }//end delete



}
