package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.PersonAuthentication;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.token.Token;
import com.moon.trackingsystem.models.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegisterService {
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private SMSService smsService;
    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<String> register(PersonAuthentication personAuthentication) {
        Token token = tokenRepository.findByCode(personAuthentication.getTokenCode());
        if (token != null) {
            if (personAuthentication.getEmail().equals(token.getEmail())) {
                Person person = new Person().builder().firstName(personAuthentication.getName()).email(personAuthentication.getEmail()).phoneNumber(personAuthentication.getPhone()).password(new Random().nextInt(999999999) + "").build();
                smsService.setMessage("رمز شما برابر " + person.getPassword());
                smsService.setPhoneNumber(person.getPhoneNumber());
                smsService.send();
                token.setStatus(false);
                tokenRepository.save(token);
                personRepository.save(person);
                return ResponseEntity.ok().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

}
