package com.moon.trackingsystem.controller.otp;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OTPRestController {
    @Autowired
    private OTPService otpService;

    @GetMapping("/send-temp-pass/{phoneNumber}")
    private ResponseEntity<Person> sendTempPassword(@PathVariable String phoneNumber) {
        Person person = otpService.sendTempPassword(phoneNumber);
        if (person==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(person);
    }//end sendTempPassword

    @PostMapping("/send-temp-pass-authentication")
    private ResponseEntity<Person>tTempPasswordAuthentication(@RequestBody Authentication authentication) {
        return otpService.otpAuthentication(authentication);
    }//end sendTempPassword

}
