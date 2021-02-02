package com.moon.trackingsystem;

import com.moon.trackingsystem.controller.UploadFile;
import com.moon.trackingsystem.service.AdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class TrackingSystemApplication {

    public static void main(String[] args) {
        new File(UploadFile.uploadDirectory).mkdir();
        SpringApplication.run(TrackingSystemApplication.class, args);
    }
}
