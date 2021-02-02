package com.moon.trackingsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonAuthentication {
    private String tokenCode;
    private String name;
    private String email;
    private String phone;

}
