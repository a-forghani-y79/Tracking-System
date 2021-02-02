package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    private PersonRepository personRepository;

    public LoginService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean phoneNumberExists(String phoneNumber) {
        for (Person person : personRepository.findAll())
            if (person.getPhoneNumber().equals(phoneNumber))
                return true;
        return false;
    }//end phoneNumberExists

    public ResponseEntity<Person> authentication(Authentication info) {
//        for(Person person : personRepository.findAll())
//            if(person.getPhoneNumber().equals(info.getPhone()) && person.getPassword().equals(info.getPassword()))
//                return person;
        Person person = personRepository.findByPhoneNumber(info.getPhone());
        if (person != null && person.getPassword().equals(info.getPassword())) {
            return ResponseEntity.ok(person);

        }

        return ResponseEntity.notFound().build();

    }//end authentication

//    public boolean addTempPassword(int personID, String code) {
//
//        return true;
//    }//end sendTempPassword


}//end class
