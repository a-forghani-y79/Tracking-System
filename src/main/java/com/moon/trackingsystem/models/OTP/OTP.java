package com.moon.trackingsystem.models.OTP;


import com.moon.trackingsystem.models.person.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OTP")
public class OTP  {
    @Id
    @GeneratedValue
    private String id;
    private boolean expired;
    private Date generatedTime;
    private Date endTime;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Person person;



}
