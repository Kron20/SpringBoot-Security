package com.springboot.springbootapp.controller;

import com.springboot.springbootapp.model.User;
import com.springboot.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/lk")
    public String getUserPage2(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "userPage";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.showById(id));
        return "userPage";
    }
}

