package com.moon.trackingsystem.models.tempPassword;

import com.moon.trackingsystem.models.tempPassword.TempPassword;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class TempPasswordRepositoryImpl {
    private EntityManager entityManager;

    public TempPasswordRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(TempPassword tempPassword) {
        Session session = entityManager.unwrap(Session.class);
        session.save(tempPassword);
        System.out.println(tempPassword);
    }//end add

    @Transactional
    public TempPassword get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TempPassword.class, id);
    }//end get

    @Transactional
    public TempPassword update(int id) {
        Session session = entityManager.unwrap(Session.class);
        TempPassword tempPassword = session.get(TempPassword.class, id);
        if(tempPassword == null)
            return null;
        else {
            session.update(tempPassword);
            return tempPassword;
        }
    }//end update

    @Transactional
    public TempPassword delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        TempPassword tempPassword = session.get(TempPassword.class, id);
        if(tempPassword == null)
            return null;
        else {
            session.delete(tempPassword);
            return tempPassword;
        }
    }//end delete


}
