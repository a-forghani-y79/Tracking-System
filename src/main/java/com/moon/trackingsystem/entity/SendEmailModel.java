package com.moon.trackingsystem.entity;

import lombok.Data;

@Data
public class SendEmailModel {

    private String to;
    private String subject;
    private String description;
}
