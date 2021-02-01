package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.models.Person;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean phoneNumberExists(String phoneNumber) {
        // TODO make a hibernate session and authenticate phone number
        return true;
    }//end phoneNumberExists

    public Person authentication(Authentication info) {
        // TODO make a hibernate session and authenticate entered login info
        return null;
    }//end authentication

}//end class
