package com.moon.trackingsystem;

import com.moon.trackingsystem.controller.UploadFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;


@SpringBootApplication
public class TrackingSystemApplication {

    public static void main(String[] args) {

        new File(UploadFile.uploadDirectory).mkdir();
        SpringApplication.run(TrackingSystemApplication.class, args);
    }
}
