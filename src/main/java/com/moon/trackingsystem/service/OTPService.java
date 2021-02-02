package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.tempPassword.TempPassword;
import com.moon.trackingsystem.models.tempPassword.TempPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OTPService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TempPasswordRepository tempPasswordRepository;
@Autowired
 private SMSService smsService;
    public Person sendTempPassword(String phone) {
        int random = (int) (Math.random() * (999999 - 100000)) + 100000;
        System.out.println("Code: " + random + "\nSMS sent");

        Person person = personRepository.findByPhoneNumber(phone);
        TempPassword tempPassword = new TempPassword().builder().code(random + "").created_at(new Date()).build();
        if (person != null) {
            smsService.setMessage("رمز یکبار مصرف شما "+random);
            smsService.setPhoneNumber(phone);
            smsService.send();
            tempPasswordRepository.save(tempPassword);
            person.setTempPassword(tempPassword);
            personRepository.save(person);
            return person;
        }
        return null;
    }

    public ResponseEntity<Person> otpAuthentication(Authentication info) {

        Person person = personRepository.findByPhoneNumber(info.getPhone());
        if (person != null && person.getTempPassword().getCode().equals(info.getPassword())) {
            return ResponseEntity.ok(person);
        }

        return ResponseEntity.notFound().build();

    }//end authentication

}
