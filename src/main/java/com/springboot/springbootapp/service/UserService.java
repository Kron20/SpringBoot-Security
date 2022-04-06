package com.springboot.springbootapp.service;

import com.springboot.springbootapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User showById(Long id);

    User update(User user);

    void addUser(User user);

    void delete(Long id);

    List<User> getAllUsers();
    //User getUserByUsername(String username);
}
