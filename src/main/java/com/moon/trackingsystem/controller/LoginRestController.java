package com.moon.trackingsystem.controller;

import com.moon.trackingsystem.entity.Authentication;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.tempPassword.TempPassword;
import com.moon.trackingsystem.models.tempPassword.TempPasswordRepository;
import com.moon.trackingsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;

@RestController
@RequestMapping(value = "/login-rest")
public class LoginRestController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private PersonRepository personRepository;

//    @Autowired
//    public LoginRestController(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }//end constructor

    @PostConstruct
    public void setup() {
        loginService = new LoginService(personRepository);
    }//end setup


    @GetMapping("/{phoneNumber}")
    private boolean phoneNumberExists(@PathVariable String phoneNumber) {
        return loginService.phoneNumberExists(phoneNumber);
    }//end phoneNumberExists


//    @PostMapping("/authenticate")
//    private Person authentication(@RequestBody Authentication info) {
//        System.out.println("phone: " + info.getPhone());
//        System.out.println("password: " + info.getPassword());
//        Person person = loginService.authentication(info);
//        if(person == null)
//            return null;
//        else {
//            System.out.println("Json : " + person);
//            return person;
//        }
//    }//end authentication
    @PostMapping("/authenticate")
    private ResponseEntity<Person> authentication(@RequestBody Authentication info) {
        System.out.println("phone: " + info.getPhone());
        System.out.println("password: " + info.getPassword());
        return loginService.authentication(info);

    }//end authentication




}//end class
