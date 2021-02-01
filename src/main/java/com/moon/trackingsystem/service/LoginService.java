package com.moon.trackingsystem.service;

import com.moon.trackingsystem.models.person.PersonRepositoryImpl;
import com.moon.trackingsystem.entity.Authentication;

import com.moon.trackingsystem.models.person.Person;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private PersonRepositoryImpl personRepositoryImpl;

    public LoginService(PersonRepositoryImpl personRepositoryImpl) {
        this.personRepositoryImpl = personRepositoryImpl;
    }

    public boolean phoneNumberExists(String phoneNumber) {
        for(Person person : personRepositoryImpl.getAll())
            if(person.getPhoneNumber().equals(phoneNumber))
                return true;
        return false;
    }//end phoneNumberExists

    public Person authentication(Authentication info) {
        for(Person person : personRepositoryImpl.getAll())
            if(person.getPhoneNumber().equals(info.getPhone()) && person.getPassword().equals(info.getPassword()))
                return person;
        return null;
    }//end authentication

    public boolean addTempPassword(int personID, String code) {

        return true;
    }//end sendTempPassword


}//end class
