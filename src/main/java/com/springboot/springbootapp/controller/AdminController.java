package com.springboot.springbootapp.controller;

import com.springboot.springbootapp.model.Role;
import com.springboot.springbootapp.model.User;
import com.springboot.springbootapp.service.RoleService;
import com.springboot.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin")
    public String welcome() {
        return "redirect:/admin/all";
    }

    @GetMapping(value = "admin/all")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping(value = "admin/add")
    public String saveUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "saveUser";
    }

    @PostMapping(value = "admin/add")
    public String postSaveUser(@ModelAttribute("user") User user,
                               @RequestParam(required = false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        }
        user.setRoles(roles);
        userService.addUser(user);

        return "redirect:/admin";
    }


    @GetMapping(value = "admin/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.showById(id);
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (role.equals(roleService.getRoleByName("ROLE_ADMIN"))) {
                model.addAttribute("roleAdmin", true);
            }
        }
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "admin/edit")
    public String postEditUser(@ModelAttribute("user") User user,
                               @RequestParam(required = false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        }
        user.setRoles(roles);
        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
