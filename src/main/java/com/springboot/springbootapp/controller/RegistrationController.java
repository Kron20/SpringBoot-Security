package com.springboot.springbootapp.controller;

import com.springboot.springbootapp.model.User;
import com.springboot.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/")
    public String getHomePage(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("Welcome to Spring SECURITY application");
        messages.add("This is the start page");
        model.addAttribute("messages", messages);
        return "helloPage";
    }

    @GetMapping(value = "login")
    public String getLoginPage() {
        return "loginPage";
    }
}
