package com.moon.trackingsystem.controller;

import com.moon.trackingsystem.entity.Authentication;

import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/login-rest")
public class LoginRestController {
    private LoginService loginService;
    private PersonRepository personRepository;

    @Autowired
    public LoginRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }//end constructor

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
        Person person = loginService.authentication(info);
        if(person == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(person);
        }
    }//end authentication


    @GetMapping("/send-temp-pass/{phoneNumber}")
    private boolean sendTempPassword(@PathVariable String phoneNumber) {
        int random = (int) (Math.random() * (999999 - 100000)) + 100000;
        System.out.println("Code: " + random + "\nSMS sent");
        //TODO setup sms api & complete throwaway service
        //fixme
        return true;
    }//end sendTempPassword


}//end class
