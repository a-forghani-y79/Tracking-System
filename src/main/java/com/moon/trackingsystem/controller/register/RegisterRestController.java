package com.moon.trackingsystem.controller.register;

import com.moon.trackingsystem.entity.PersonAuthentication;
import com.moon.trackingsystem.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterRestController {
    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody PersonAuthentication personAuthentication){
        return new RegisterService().register(personAuthentication);
    }

}
