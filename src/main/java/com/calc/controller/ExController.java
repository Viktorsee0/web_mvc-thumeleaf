package com.calc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(NullPointerException.class)
    public String npe(NullPointerException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error";
    }

    @ExceptionHandler(RuntimeException.class)
    public String re(RuntimeException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error";
    }

}
