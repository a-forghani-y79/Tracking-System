package com.moon.trackingsystem.models.tempPassword;

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
@Table(name = "tmp_password")
public class TempPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String code;
    private Date created_at;
    private Date time;


}
