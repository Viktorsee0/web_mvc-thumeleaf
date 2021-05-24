package com.calc.controller;


import com.calc.model.Operation;
import com.calc.model.User;
import com.calc.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private OperationService service;

    @GetMapping
    public String viewPage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "error";
        }
        List<Operation> operations = service.getByUser(user);
        if (!operations.isEmpty()){
            model.addAttribute(operations);
        }
        return "history";
    }
}
