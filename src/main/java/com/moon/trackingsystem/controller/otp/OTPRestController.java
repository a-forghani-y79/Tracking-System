package com.moon.trackingsystem.controller.otp;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.tempPassword.TempPassword;
import com.moon.trackingsystem.models.tempPassword.TempPasswordRepository;
import com.moon.trackingsystem.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OTPRestController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TempPasswordRepository tempPasswordRepository;

    @GetMapping("/send-temp-pass/{phoneNumber}")
    private ResponseEntity<Person> sendTempPassword(@PathVariable String phoneNumber) {
        return new OTPService(personRepository, tempPasswordRepository).sendTempPassword(phoneNumber);
    }//end sendTempPassword

    @PostMapping("/send-temp-pass-authentication")
    private ResponseEntity<Person>tTempPasswordAuthentication(@PathVariable Authentication authentication) {
        return new OTPService(personRepository, tempPasswordRepository).otpAuthentication(authentication);
    }//end sendTempPassword

}
