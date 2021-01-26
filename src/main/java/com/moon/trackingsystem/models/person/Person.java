package com.moon.trackingsystem.models.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")

public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private int id;
        private String fullName;
        private String email;
        private String roll;



}
