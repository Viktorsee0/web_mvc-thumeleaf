package com.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/exit")
public class ExitController {
    @GetMapping
    public String viewPage(HttpSession session){
        session.invalidate();
        return "home";
    }
}
