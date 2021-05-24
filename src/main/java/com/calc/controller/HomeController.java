package com.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.view.ThymeleafView;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String viewPage(Model model){
        model.addAttribute("c","pizdec");
        return "home";
    }
}
