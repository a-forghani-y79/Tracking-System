package com.moon.trackingsystem.models.login;


import com.moon.trackingsystem.models.person.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String passWord;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person person;

}
