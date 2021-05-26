package com.calc.controller;


import com.calc.model.User;
import com.calc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    @Autowired
    private UserService service;

    @GetMapping
    public String viewPage(Model model){
        model.addAttribute("user", new User());
        return "auth";
    }

    @PostMapping
    public String viewPage(User user, Model model, HttpSession session){
        User myUser = service.getByLogin(user);
        if (myUser != null && myUser.getPassword().equals(user.getPassword())){
            session.setAttribute("user", myUser);
            return "redirect:calc";
        }
        model.addAttribute("message","Wrong login or password");
        return "auth";
    }
}
