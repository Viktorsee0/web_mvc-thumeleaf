package com.calc.controller;

import com.calc.model.User;
import com.calc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    private UserService service;

    @GetMapping
    public String viewPage(HttpSession session){
        if (session.getAttribute("user") != null){
            return "error";
        }
        return "registration";
    }

    @PostMapping
    public String viewPage(User user){
        service.save(user);
        return "redirect:/auth";
    }

}
