package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.Authentication;
import com.moon.trackingsystem.models.person.Person;
import com.moon.trackingsystem.models.person.PersonRepository;
import com.moon.trackingsystem.models.tempPassword.TempPassword;
import com.moon.trackingsystem.models.tempPassword.TempPasswordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OTPService {
    private PersonRepository personRepository;
    private TempPasswordRepository tempPasswordRepository;

    public OTPService(PersonRepository personRepository, TempPasswordRepository tempPasswordRepository) {
        this.personRepository = personRepository;
        this.tempPasswordRepository = tempPasswordRepository;
    }

    public ResponseEntity<Person> sendTempPassword(String phone){
        int random = (int) (Math.random() * (999999 - 100000)) + 100000;
        System.out.println("Code: " + random + "\nSMS sent");
        //TODO setup sms api & complete throwaway service
        Person person = personRepository.findByPhoneNumber(phone);
        TempPassword tempPassword = new TempPassword().builder().code(random+"").created_at(new Date()).build();
        if (person != null){
            tempPasswordRepository.save(tempPassword);
            person.setTempPassword(tempPassword);
            personRepository.save(person);

            return ResponseEntity.ok(person);

        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Person> otpAuthentication(Authentication info) {

        Person person = personRepository.findByPhoneNumber(info.getPhone());
        if (person != null && person.getTempPassword().getCode().equals(info.getPassword())) {
            return ResponseEntity.ok(person);
        }

        return ResponseEntity.notFound().build();

    }//end authentication

}
