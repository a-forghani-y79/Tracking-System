package com.moon.trackingsystem.controller;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.entity.ThrowawayAuth;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.service.LoginService;
import com.moon.trackingsystem.service.ThrowawayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/login-rest")
public class LoginRestController {
    private LoginService loginService;

    @PostConstruct
    public void setup() {
        loginService = new LoginService();
    }//end setup


    @GetMapping("/{phoneNumber}")
    private boolean phoneNumberExists(@PathVariable String phoneNumber) {
        return loginService.phoneNumberExists(phoneNumber);
    }//end phoneNumberExists


    @GetMapping("/authenticate")
    private boolean authentication(@RequestBody Authentication info, HttpSession session) {
        Person person = loginService.authentication(info);
        if(person == null)
            return false;
        else {
            session.setAttribute("id", person.getId());
            session.setAttribute("password", person.getPassword());
            session.setAttribute("role", person.getRole());
            return true;
        }
    }//end authentication

    @GetMapping("/send-temp-pass/{phoneNumber}")
    private boolean sendTempPassword(@PathVariable String phoneNumber) {
        int random = (int) (Math.random() * (999999 - 100000)) + 100000;
        //TODO setup sms api & complete throwaway service
        ThrowawayAuth throwawayAuth = new ThrowawayAuth(phoneNumber, String.valueOf(random));
        ThrowawayService throwawayService = ThrowawayService.getInstance();
        throwawayService.add(throwawayAuth);
        System.out.println("Code: " + random + "\nSMS sent");
        return true;
    }//end sendTempPassword


}//end class
