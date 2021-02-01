package com.moon.trackingsystem.models.person;


import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.team.Team;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonRepositoryImpl {

    private EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }//end constructor

    @Transactional
    public void add(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.save(person);
        System.out.println(person);
    }//end add

    @Transactional
    public boolean addTempPassword(int personID, String code) {
        Person person = get(personID);
        if(person == null)
            return false;
        else {
//            LocalTime localTime = LocalTime.now();
//            LocalTime expireTime = localTime.plusSeconds(120);
//            TempPassword tempPassword = new TempPassword(code, localTime, expireTime);
//            person.setTempPassword();
            return true;
        }
    }//end addTempPassword

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

    @Transactional
    public void addTeam(int id, Team team) {
        Session session = entityManager.unwrap(Session.class);
        Person person = get(id);
        if(person != null) {
            person.addTeam(team);
            session.update(person);
        }
    }//end addTeam

    @Transactional
    public List<Team> getTeams(int id) {
        Session session = entityManager.unwrap(Session.class);
        Person person = get(id);
        if(person == null)
            return null;
        else
            return person.getTeams();
    }//end getTeams

    @Transactional
    public void removeTeam(int id, int teamID) {
        Person person = get(id);
        if(person != null)
            person.getTeams().removeIf(team -> team.getId() == teamID);
        else
            System.out.println("Person > null");
    }//end removeTeam

}//end PersonDAO
