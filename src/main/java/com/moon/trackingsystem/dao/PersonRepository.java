package com.moon.trackingsystem.dao;


import com.moon.trackingsystem.models.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonRepository {

    private EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.save(person);
        System.out.println("New person saved!");
        System.out.println(person);
    }//end add

    @Transactional
    public Person update(int id) {
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, id);
        if(person == null)
            return null;
        else {
            session.update(person);
            return person;
        }
    }//end update

    @Transactional
    public List<Person> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Person> query = session.createQuery("from Person", Person.class);
        return query.getResultList();
    }//end getAll

    @Transactional
    public Person get(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Person.class, id);
    }//end getByID

    @Transactional
    public Person get(String phoneNumber) {
        Session session = entityManager.unwrap(Session.class);
        String query = "FROM Person p WHERE p.phoneNumber='" + phoneNumber + "'";
        List<Person> persons = session.createQuery(query).getResultList();
        if(persons.size() == 0)
            return null;
        else
            return persons.get(0);
    }//end getByPhoneNumber

    @Transactional
    public Person delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, id);
        if(person == null)
            return null;
        else {
            session.delete(person);
            return person;
        }
    }//end delete

    @Transactional
    public Person delete(String phoneNumber) {
        Session session = entityManager.unwrap(Session.class);
        Person person = get(phoneNumber);
        if(person == null)
            return null;
        else {
            session.delete(person);
            return person;
        }
    }//end delete

}//end PersonDAO
