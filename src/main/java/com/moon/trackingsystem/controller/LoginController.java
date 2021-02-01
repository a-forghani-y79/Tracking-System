package com.moon.trackingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    private String showLoginIndex() {
        return "loginIndex";
    }//end showLoginIndex

    @GetMapping("/home")
    private String showHomePage(HttpSession session) {
        // TODO authenticate request
        String role = "";
        if(session.getAttribute("role") != null)
            role = session.getAttribute("role").toString();
        switch (role) {
            case "USER":
                System.out.println("loading user home page");
                return "userHome";
            case "MANAGER":
                return "managerHome";
            case "ADMIN":
                return "adminHome";
            default:
                return "notFound";
        }
    }//end showHomePage


    @GetMapping("/tmp")
    private String showThrowawayPage() {
        return "loginTmp";
    }//end showThrowawayPage



}//end class
