package com.calc.controller;

import com.calc.model.Action;
import com.calc.model.Operation;
import com.calc.model.User;
import com.calc.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    @Autowired
    Map<String, Action> map;

    @Autowired
    OperationService service;

    @GetMapping
    public String viewPage(HttpSession session) {
        if (session.getAttribute("user") == null){
            return "error";
        }
        return "calc";
    }

    @PostMapping
    public String viewPage(Operation operation, Model model, HttpSession session) {

        System.out.println(operation);

        User user = (User) session.getAttribute("user");
        double res = map.get(operation.getOp()).execute(operation.getFNum(), operation.getSNum());
        operation.setResult(res);
        operation.setUser(user);
        service.save(operation);
        model.addAttribute("operation", operation);
        return "calc";
    }
}
