package com.moon.trackingsystem.models.section;

import com.moon.trackingsystem.models.section.Section;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class SectionRepositoryImpl {
    private EntityManager entityManager;

    public SectionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Section section) {
        Session session = entityManager.unwrap(Session.class);
        session.save(section);
        System.out.println(section);
    }//end add

    @Transactional
    public Section get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Section.class, id);
    }//end get

    @Transactional
    public List<Section> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Section> query = session.createQuery("from Section", Section.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Section update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Section section = session.get(Section.class, id);
        if(section == null)
            return null;
        else {
            session.update(section);
            return section;
        }
    }//end update

    @Transactional
    public Section delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Section section = session.get(Section.class, id);
        if(section == null)
            return null;
        else {
            session.delete(section);
            return section;
        }
    }//end delete


}
