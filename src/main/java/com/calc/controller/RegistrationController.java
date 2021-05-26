package com.calc.controller;

import com.calc.model.User;
import com.calc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    private UserService service;


    @GetMapping
    public String viewPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping()
    public String viewPage( @Valid User user ,BindingResult bindingResult, Model model, HttpSession session){

        if (bindingResult.hasErrors()){
            return "registration";
        }

        if (user.getLogin().equals("111")){
            throw new NullPointerException("NUL::");
        }

        service.save(user);
        return "redirect:/auth";
    }

}
