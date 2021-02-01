package com.moon.trackingsystem.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //clear session
        return "loginIndex";
    }//end logout

}//end class
